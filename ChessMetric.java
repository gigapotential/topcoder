
public class ChessMetric {

/*
   .......
   ..L.L..     L1
   .LXXXL.     L2
   ..XKX..
   .LXXXL.     L3
   ..L.L..     L4
   .......
*/
  
  long[][][] hm; // how many
  public long howMany(int size, int[] start, int[] end, int numMoves) {
    hm = new long[size+4][size+4][numMoves +1]; // 100*100*50 max. : ~4MB

    // base case: shift it to +2 so as to not deal with edge conditions
    hm[start[0] +2 ][start[1] +2][0] = 1;

    for(int m = 1; m <= numMoves; m++) {
      for(int i = 2; i < size +2; ++i ) {
        for(int j = 2; j < size +2; ++j) {
          hm[i][j][m] = 
            hm[i-1][j-1][m-1] + hm[i-1][j][m-1] + hm[i-1][j+1][m-1] + // upper X
            hm[i][j-1][m-1] + hm[i][j+1][m-1] + // same row as K
            hm[i+1][j-1][m-1] + hm[i+1][j][m-1] + hm[i+1][j+1][m-1] + // lower X
            hm[i-2][j-1][m-1] + hm[i-2][j+1][m-1] + // L1
            hm[i-1][j-2][m-1] + hm[i-1][j+2][m-1] + // L2
            hm[i+1][j-2][m-1] + hm[i+1][j+2][m-1] + // L3
            hm[i+2][j-1][m-1] + hm[i+2][j+1][m-1] ; // L4
        }
      }
    }
    
    return hm[end[0] +2][end[1] +2][numMoves];
  }

}
