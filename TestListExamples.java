import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test
  public void testFilterEmpty(){
    List<String> empty = Arrays.asList();
    List<String> result = ListExamples.filter(empty, new IsMoon());
    List<String> expected = Arrays.asList();
    assertEquals(expected, result);
    assertEquals(0, result.size());
  }

  @Test
  public void testFilterNoMatches(){
    List<String> full = Arrays.asList("a", "b", "c");
    List<String> expected = Arrays.asList();
    List<String> result = ListExamples.filter(full, new IsMoon());
    assertEquals(expected, result);
    assertEquals(0, result.size());
  }

  
  @Test
  public void testFilterAllMatches(){
    List<String> full = Arrays.asList("moon", "moon", "moon");
    List<String> expected = Arrays.asList("moon", "moon", "moon");
    List<String> result = ListExamples.filter(full, new IsMoon());
    assertEquals(expected, result);
  }

  @Test
  public void testFilterSomeMatches(){
    List<String> full = Arrays.asList("moon", "moon", "sun");
    List<String> expected = Arrays.asList("moon", "moon");
    List<String> result = ListExamples.filter(full, new IsMoon());
    assertEquals(expected, result);
    full = Arrays.asList("sun", "moon", "sun");
    expected = Arrays.asList("moon");
    result = ListExamples.filter(full, new IsMoon());
    assertEquals(expected,  result);
    full = Arrays.asList("moon", "moon", "sun", "moon");
    expected = Arrays.asList("moon", "moon", "moon");
    result = ListExamples.filter(full, new IsMoon());
    assertEquals(expected, result);
  }
}
