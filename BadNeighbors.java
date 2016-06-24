import java.util.ArrayList;

/*
Problem Statement:
https://community.topcoder.com/stat?c=problem_statement&pm=2402&rd=5009
*/

public class BadNeighbors {

  public int maxNonConsecutiveSum(int[] donations) {

    if(donations == null)
      return 0;

    int maxSum = 0;
    int prevMaxSum = 0;
    int prevPrevMaxSum = 0;
    int N = donations.length;
    
    for(int i = 0; i < N ; ++i) {
      maxSum = Math.max(prevMaxSum, (prevPrevMaxSum + donations[i]));
      prevPrevMaxSum = prevMaxSum;
      prevMaxSum = maxSum;    
    }  
    
    return maxSum;
  }

  private int[] getSubArray(int[] array, int exclude) {
    if(array == null || array.length == 0) 
      return null;
    
    ArrayList<Integer> newArray = new ArrayList<>();
  
    int nextNeighbor = (exclude +1) % array.length;
    int prevNeighbor = (exclude -1 + array.length) % array.length; 

    int begin = (nextNeighbor + 1) % array.length;
    int end = (prevNeighbor - 1 + array.length) % array.length;

    for(int i = begin; i != prevNeighbor; i = ( (i+1) % array.length)) {
      if(i == exclude) continue;
      newArray.add(array[i]);
    }
   
    int[] newa = new int[newArray.size()]; 
    
    //System.out.println("sub array: ");
    for(int i =0; i< newArray.size(); ++i) {
      
      newa[i] = newArray.get(i);
      //System.out.print(newa[i]  + " ");
    }
    //System.out.println("");
 
    return newa;
  }
    
  public int maxDonations(int[] donations) {

    if(donations == null) 
      return 0;

    int maxD = 0;
    int N = donations.length;

    for(int i=0; i<N; ++i) {
      int[] linearDonations = getSubArray(donations, i);
      int maxNCS = maxNonConsecutiveSum(linearDonations);
      //System.out.println("exclude " + i + " maxNCS: " + maxNCS);
      maxD = Math.max(maxD, donations[i] + maxNCS);
    }
    return maxD;
  }

}
