CPATH=".;../lib/hamcrest-core-1.3.jar;../lib/junit-4.13.2.jar"

rm -rf student-submission
git clone $1 student-submission
echo 'Finished cloning'

if [ -f student-submission/ListExamples.java ]
then 
    echo 'Java file found'
    javac student-submission/ListExamples.java
else
    echo 'Error: Java file not found, error code '$?''
    echo 'The directory is as follows: '$(ls)''
    exit
fi

for file in *.java
do
    cp $file student-submission/$file 
done

cd student-submission
javac -cp $CPATH *.java
if [ $? -eq 0 ]
then 
    echo 'Compiled successfully'
else
    echo 'Failed to compile: error code '$?''
    exit
fi

java -cp $CPATH org.junit.runner.JUnitCore TestListExamples > output.txt 2>&1
cat output.txt