import java.util.Collections;
import java.util.PriorityQueue;

public class FoxAndMp3Easy {

  public String[] playList(int N) {


    PriorityQueue<String> heap = new PriorityQueue<>(50, Collections.reverseOrder());
    
    for(int i = 1; i <= N; ++i) {
      String integer = String.valueOf(i);
      if(heap.peek() !=  null) { 
        if( heap.size() < 50 ) {
          heap.add(integer);
        } else if( integer.compareTo(heap.peek()) < 0 ) {
          heap.add(integer);
          heap.poll();
        }
      } else {
        heap.add(integer);
      }    
    
    }

    String[] solution = new String[heap.size()];
    for(int i = heap.size() -1 ; i >= 0; --i) {
      solution[i] = heap.poll();
      solution[i] = solution[i].concat(".mp3");
    }
    return solution;
  }

  
}
