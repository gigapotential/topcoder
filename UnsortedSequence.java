import java.util.Arrays;


public class UnsortedSequence {

  int[] getUnsorted(int[] s) {
    boolean found = false;
    Arrays.sort(s);
    int last = s[s.length -1];
    for(int i = s.length -2; i >= 0; --i) {
      if( s[i] < last ) {
        found = true;
        int temp = s[i];  
        s[i] = last;
        s[i+1] = temp;
        break;
      }
    }
    
    if(found) 
      return s;
    else
      return new int[0];
  }  

}
