import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;


public class TestTheEncryptionDivTwo {
 
  protected TheEncryptionDivTwo solution;

  @Before
  public void doSetup() {
    solution = new TheEncryptionDivTwo();
  }  
  
  @Test
  public void test0() {
    String input = "hello";
    String expected = "abccd";
    assertEquals(expected, solution.encrypt(input));
  }
  
  @Test
  public void test1() {
    String input = "abcd";
    String expected = "abcd";
    assertEquals(expected, solution.encrypt(input));
  }

  @Test
  public void test2() {
    String input = "topcoder";
    String expected = "abcdbefg";
    assertEquals(expected, solution.encrypt(input));
  }
  
  @Test
  public void test3() {
    String input = "encryption";
    String expected = "abcdefghib";
    assertEquals(expected, solution.encrypt(input));
  }

}
