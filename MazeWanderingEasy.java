
public class MazeWanderingEasy {
  
  int R, C;
  char M[][];
  int mR, mC;
  int cR, cC;  
  boolean found = false;

  public int decisions(String[] maze) {
    found = false;
    R = maze.length;
    C = maze[0].length(); 
    M = new char[R][C];
    //int mR, mC; // mouse row, column
    //int cR, cC; // cheese row, column
  
    for(int i = 0; i < R; ++i) {
      for(int j = 0; j < C; ++j) {
        M[i][j] = maze[i].charAt(j);
        if(maze[i].charAt(j) == 'M') {
          mR= i; mC = j;
        }
        if(maze[i].charAt(j) == '*') {
          cR = i; cC = j;
        }
      }
    }

    
    dfs(mR, mC);

        
    return countDecision();  
  }

  private int countDecision() {
    int decisions =0;
    for(int i = 0 ; i < R; ++i) {
      for(int j = 0; j < C; ++j) {
        if( M[i][j] == 'V') { 
           if( (i+1) < R  && M[i+1][j]  == '.' ) 
             decisions++;
           else if( (i-1) >= 0 && M[i-1][j] == '.')
             decisions++;
           else if( (j-1) >= 0 && M[i][j-1] == '.')
             decisions++; 
           else if( (j+1) < C && M[i][j+1] == '.')
             decisions++; 
        }
      }
    } 
    return decisions; 
  }

  private void printMaze() {
    for(int i = 0; i < R; ++i ) {
      for(int j = 0; j < C; ++j) {
        System.out.print(M[i][j]+ " ");
      }
      System.out.print("\n");
    }
  }

  private void dfs(int r, int c) {
  
      if(r < 0 || r >=R || c < 0 || c >= C 
          || M[r][c] == 'X' || M[r][c] == 'V' ) {
        return; 
      }
       
      if(M[r][c] == '*' ) {
        found = true;

        return;
      }

      // mark visited
      M[r][c] = 'V';
    
      if(!found) {
        dfs(r+1, c);
      } 
      
      if(!found) {
        dfs(r, c+1);
      }
  
      if(!found) {
        dfs(r-1, c);
      }

      if(!found) {
        dfs(r, c-1);
      }
      
      if(!found) {
        // unvisit 
        M[r][c] = '.';
      }
      
  }

  public static void main(String[] args) {

  String[] maze = 
{"..........*",
 ".XXXXXXXXXX",
 "...........",
 "XXXXXXXXXX.",
 "M.........."};


/*
    String[] maze = 
      
{".X.X......X",
 ".X*.X.XXX.X",
 ".XX.X.XM...",
 "......XXXX."};
*/
    MazeWanderingEasy mwe = new MazeWanderingEasy();
    System.out.println("DECISIONS: " + mwe.decisions(maze));    
  
  }
  
}
