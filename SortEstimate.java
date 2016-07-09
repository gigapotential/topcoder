

public class SortEstimate {

   private double function(int c, double n, int time) {
      return (c*n*Math.log(n)/Math.log(2)) - time;
   }
  

   public double howMany(int c, int time) {
      double n = time;
      double prevn = time +1;

      // make funciton positive
      while(function(c,n, time) < 0) {
        n = 2*n;
      }

      // approach from positive side
      while(true) {
        double func = function(c, n, time);
        if(Math.abs(func) < 1e-6) break;
        if( func > 0 ) {
          prevn = n;
          n = n/2;
        } else {
          n = n + (prevn -n)/2.0d;
        }
      }    
  
      return n;
   }

   public static void main(String[] args) {
      int c = Integer.valueOf(args[0]);
      int time = Integer.valueOf(args[1]);
      SortEstimate se = new SortEstimate();
      System.out.println("SE: " + se.howMany(c, time));
   }
}
