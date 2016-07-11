import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class TestMazeWanderingEasy {

  protected MazeWanderingEasy mwe;

  @Before
  public void setup() {
    mwe = new MazeWanderingEasy();
  }

  @Test
  public void test0() {
    String[] maze = {"*.M"};
    assertEquals(0, mwe.decisions(maze));
  }

  @Test
  public void test1() {
    String[] maze = {"*.M", ".X."};
    assertEquals(1, mwe.decisions(maze));
  }
  
  @Test
  public void test2() {
    String[] maze = {"...", "XMX", "..*"};
    assertEquals(2, mwe.decisions(maze));
  }

  @Test
  public void test3() {
    String[] maze = {".X.X......X", ".X*.X.XXX.X", ".XX.X.XM...", "......XXXX."};
    assertEquals(3, mwe.decisions(maze));
  }
  
  @Test
  public void test4() {
    String[] maze = 
{"..........*",
 ".XXXXXXXXXX",
 "...........",
 "XXXXXXXXXX.",
 "M.........."};
    assertEquals(0, mwe.decisions(maze));
  }


}
