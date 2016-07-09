
public class AutoLoan {

  private double P;
  private double E;
  private int N;
  private double I;
  
 // c = (1 + I/1200)
 // PC^(n+1) - (P+E)*c^n + E = 0

  private double c() {
    return (1 + (I/1200.0));
  }

  private double function() {
    return P * Math.pow(c(), N+1) - ((P+E)* Math.pow(c(), N)) + E;
  }

  private double interest() {
    double prevI = 100.0;
    I = 100.0;
   
    while(true) {
      double func = function();
      if( func < 0 ) {
          I = I + (prevI -I)/2;
       } else {
          prevI = I;
          I = I /2;
       }
       
       if(Math.abs(I-prevI) < 1e-10 ) break;
    }
    return I;
  }    


  public double interestRate(double price, double monthlyPayment, int loanTerm) {
    P = price;
    E = monthlyPayment;
    N = loanTerm;
    return interest();    
  }

  public static void main(String[] args) {
      AutoLoan loan = new AutoLoan();
      double price = Double.valueOf(args[0]);
      double monthlyPayment = Double.valueOf(args[1]);
      int loanTerm = Integer.valueOf(args[2]);
      System.out.println("INTEREST: " + loan.interestRate(price, monthlyPayment, loanTerm));
  }

}
