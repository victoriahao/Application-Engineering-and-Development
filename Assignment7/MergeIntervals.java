import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	IntervalComparator mergeIntervals = new IntervalComparator();
    	Interval interval1 = new Interval(1,3);
    	Interval interval2 = new Interval(2,4);
    	Interval interval3 = new Interval(8,10);
    	List<Interval> list1 = Arrays.asList(interval1,interval2,interval3);
		List<Interval> result = mergeIntervals.merge(list1);
		for(int i = 0; i < result.size(); i++) {
			System.out.println("start: "+result.get(i).start+", end: "+result.get(i).end);
		}
		
	}
}
