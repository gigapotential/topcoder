import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Comparator;
import java.util.Arrays;

public class FlowerGarden {

  private static class Flower {
    int height;
    int bloom;
    int wilt; 

    private Flower(int height, int bloom, int wilt) {
      this.height = height;
      this.bloom = bloom;
      this.wilt = wilt;
    } 
  }  

  private static class FlowerComparator implements Comparator<Flower> {
    @Override
    public int compare(Flower f1, Flower f2) {
      return f1.height - f2.height;
    }
  }

  private static class Interval {
    int begin;
    int end;
    ArrayList<Flower> flowers;  
  
    private Interval(int begin, int end) {
      this.begin = begin;
      this.end = end;
      flowers = new ArrayList<>();
    }
  }
    
  private static class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval i1, Interval i2) {
      return i1.begin - i2.begin;
    }
  }

  private static class IntervalFirstFlowerComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval i1, Interval i2) {
      return i2.flowers.get(0).height - i1.flowers.get(0).height;
    }
  }

  private Flower[] flowers;
  private Interval[] intervals;
  private ArrayList<Interval> intervalStack;
  private HashMap<Interval, ArrayList<Flower>> interval;

  private boolean overlaps(Interval i1, Interval i2) {
    return Math.min(i1.end, i2.end) >= Math.max(i1.begin, i2.begin);
  }

  private boolean overlaps(Flower f1, Flower f2) {
    return Math.min(f1.wilt, f2.wilt) >= Math.max(f1.bloom, f2.bloom);
  }  

  public int[] getOrdering(int[] height, int[] bloom, int[] wilt) {
    intervals = new Interval[height.length];
    for(int i = 0; i < height.length; i++) {
      intervals[i] = new Interval(bloom[i], wilt[i]);
      intervals[i].flowers.add( new Flower(height[i], bloom[i], wilt[i])); 
    }
  
    // sort interval to merge 
    Arrays.sort(intervals, new IntervalComparator());
    intervalStack = new ArrayList<>();
    intervalStack.add(intervals[0]);
    // merge intervals
    for(int i= 1; i < intervals.length ; ++i) {
       Interval top = intervalStack.get(intervalStack.size() -1);
       if( overlaps(top, intervals[i])) {
          top.begin = Math.min(top.begin, intervals[i].begin);
          top.end = Math.max(top.end, intervals[i].end);
          for(int j = 0; j < intervals[i].flowers.size(); ++j){
             top.flowers.add(intervals[i].flowers.get(j));  
          }
       } else {
          intervalStack.add(intervals[i]);
       } 
    }
   
    FlowerComparator flowerComparator = new FlowerComparator();
    // sort flowers within same interval based on height 
    for(int i = 0; i < intervalStack.size(); ++i) {
      Collections.sort(intervalStack.get(i).flowers, flowerComparator);
    }    

    // sort intervals on stack based on first flower height
    Collections.sort(intervalStack, new IntervalFirstFlowerComparator());

    int[] returnHeights = new int[height.length];

    int index =0;
    for(int i =0; i < intervalStack.size(); ++i) {
      Interval interval = intervalStack.get(i);
      for(int j = 0; j < interval.flowers.size(); ++j) {
        returnHeights[index] = interval.flowers.get(j).height;
        index++;
      }
    } 
    
    return returnHeights;
  }  

}
