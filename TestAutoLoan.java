import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class TestAutoLoan {
  
  protected 
  AutoLoan loan;
    
  @Before
  public void setup() {
    loan = new AutoLoan();
  }

  @Test
  public void test0() {
    assertEquals(0, loan.interestRate(6800, 100, 68), 1e-9);
  }

  @Test
  public void test1() {
    assertEquals(9.56205462458368, loan.interestRate(2000, 510, 4), 1e-9);
  }
  
  @Test
  public void test2() {
    assertEquals(7.687856394581649, loan.interestRate(15000, 364, 48), 1e-9);
  }
  

}
