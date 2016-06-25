import org.junit.Test;
import static org.junit.Assert.*;

public class TestChessMetric {

    @Test  
    public void test0() {
      int size = 3;
      int[] start = new int[] {0, 0};
      int[] end = new int[] {1, 0};
      int numMoves = 1;
      
      ChessMetric cm = new ChessMetric();
      assertEquals(1, cm.howMany(size, start, end, numMoves));

    }

    @Test
    public void test1() {
      int size = 3;
      int[] start = new int[] {0, 0};
      int[] end = new int[] {1, 2};
      int numMoves = 1;
      
      ChessMetric cm = new ChessMetric();
      assertEquals(1, cm.howMany(size, start, end, numMoves));
    }
    
    @Test
    public void test2() {
      int size = 3;
      int[] start = new int[] {0, 0};
      int[] end = new int[] {2, 2};
      int numMoves = 1;
      
      ChessMetric cm = new ChessMetric();
      assertEquals(0, cm.howMany(size, start, end, numMoves));
    }
  
    @Test
    public void test3() {
      int size = 3;
      int[] start = new int[] {0, 0};
      int[] end = new int[] {0, 0};
      int numMoves = 2;
      
      ChessMetric cm = new ChessMetric();
      assertEquals(5, cm.howMany(size, start, end, numMoves));
    }

    @Test
    public void test4() {
      int size = 100;
      int[] start = new int[] {0, 0};
      int[] end = new int[] {0, 99};
      int numMoves = 50;
      
      ChessMetric cm = new ChessMetric();
      assertEquals(243097320072600L, cm.howMany(size, start, end, numMoves));
    }
    

}
