import java.util.Comparator;
import java.util.Arrays;
public class AvoidRoads {  

  private static class RoadBlock {
    int[] idx;

    private RoadBlock(int i1, int j1, int i2, int j2) {
      idx = new int[4];
      idx[0] = i1; 
      idx[1] = j1;
      idx[2] = i2;
      idx[3] = j2;
    } 

    @Override
    public String toString() {
      String str = "";
      str = "( " + idx[0] + "," + idx[1] + " ) -> ( " + idx[2]  + "," + idx[3] + " )";
      return str;
    }
    
    private RoadBlock(String bad) {
      idx = new int[4];
      int count = 0;
      for(String split: bad.split(" ")) {
        idx[count] = Integer.valueOf(split);
        count++;
      }
      
      // sort in increasing order
      if( idx[0] > idx[2] ) {
        // swap: pair's x coordinate should be in increasing order
        int temp = idx[0];
        idx[0] = idx[2];
        idx[2] = temp;

        temp = idx[1];
        idx[1] = idx[3];
        idx[3] = temp;
         
      } else if( idx[0] == idx[2] ) {
        if( idx[1] > idx[3] ){
          // swap: pair's x coordiate is same, and y coordinate should be in increasing order
          int temp = idx[1];
          idx[1] = idx[3];
          idx[3] = temp;
        }
      }
      
    }
  }
 
  private static class RoadBlockComparator implements Comparator<RoadBlock> {
    @Override
    public int compare(RoadBlock b1, RoadBlock b2) {
      if(b1.idx[0] == b2.idx[0] && b1.idx[1] == b2.idx[1] 
          && b1.idx[2] == b2.idx[2] && b1.idx[3] == b2.idx[3]) {
        return 0;
      } else {
        if( b1.idx[0] == b2.idx[0] ) {
          //compare remaining three fields
          if(b1.idx[1] == b2.idx[1]) {
            //compare on remaing two fields
            if(b1.idx[2] == b2.idx[2]) {
              //compare on fourth field
              if( b1.idx[3] < b2.idx[3])
                return -1;
              else
                return 1;
            } else {
              if( b1.idx[2] < b2.idx[2])
                return -1;
              else
                return 1;
            }
          } else {
            if( b1.idx[1] < b2.idx[1]) 
              return -1;
            else
              return 1;
          }         
        } else {
          if( b1.idx[0] < b2.idx[0] )
            return -1;
          else
            return 1;
        }
      }
    }
  }

  private RoadBlock[] roadBlocks;

  RoadBlockComparator comparator = new RoadBlockComparator();
  private boolean isBlocked(RoadBlock block) {
    if(Arrays.binarySearch(roadBlocks, block, comparator) >= 0)  {
      return true;
    }
    return false;
  }

  private boolean isBlocked(int i1, int j1, int i2, int j2) {
    // (i1, j1) < ( i2 , j2)
    RoadBlock block = new RoadBlock(i1, j1, i2, j2);
    return isBlocked(block);
  }
  

  public long numWays(int width, int height, String[] bad) {
    long num[][] = new long[width+1][height+1];
    roadBlocks = new RoadBlock[bad.length];    
    
    for(int i = 0; i < bad.length; ++i) {
      roadBlocks[i] = new RoadBlock(bad[i]);
    }

    // Sort Road blocks to do Binary Search during DP
    Arrays.sort(roadBlocks, comparator);

    // Setup base solution for DP
    num[0][0] = 1;
    int i;
    for(i = 1; i <= width; ++i) {
      if(isBlocked(i-1, 0, i, 0)) {
        num[i][0] = 0;
        break;
      } 
      num[i][0] = 1;
    } 

    while(i <= width) {
      num[i][0] = 0;
      ++i;
    }

    for(i = 1; i <= height; ++i) {
      if(isBlocked(0, i-1, 0, i)) {
        num[0][i] = 0;
        break;
      }
      num[0][i] = 1;
    } 

    while(i <= height) {
      num[0][i] = 0;
      ++i;
    }
    
    // Run DP
    for(i = 1; i <= width; ++i) {
      for(int j =1; j <= height; ++j) {
        RoadBlock fromTop = new RoadBlock(i, j-1  , i, j);
        RoadBlock fromLeft = new RoadBlock(i-1, j, i,j);
      
        if(isBlocked(fromTop) && isBlocked(fromLeft)) {
          num[i][j] = 0;
        } else if(isBlocked(fromTop)) {
          num[i][j] = num[i-1][j];
        } else if(isBlocked(fromLeft)) {
          num[i][j] = num[i][j-1];
        } else {
          num[i][j] = num[i-1][j] + num[i][j-1];
        }
        
      }
    } 

    return num[width][height]; 
  } 
  
}
