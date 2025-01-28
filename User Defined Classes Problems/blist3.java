/*
 * Bucket list (Dec 2018)
 */
import java.io.*;
import java.util.*;
public class blist3 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("blist.in"));
		PrintWriter out = new PrintWriter(new File("blist.out"));

		int n = in.nextInt();  //# of records
		ArrayList<TimePoint> pts = new ArrayList<TimePoint>();
		for(int k=0; k<n; k++) {
			int s = in.nextInt();
			int t = in.nextInt();
			int b = in.nextInt();
			
			pts.add(new TimePoint(s, 0, b));
			pts.add(new TimePoint(t, 1, b));
		}

		//sort the points by time stamp
		Collections.sort(pts, (x, y) -> x.n - y.n);
		
		int maxBucket = 0;
		int count = 0;
		for(int k=0; k<2*n; k++) {
			if(pts.get(k).type==0) { //start time
				count += pts.get(k).buckets;
				maxBucket = Math.max(maxBucket, count);
			}
			else //end time
				count -= pts.get(k).buckets;
		}

		out.println(maxBucket);
		out.close();
		in.close();
	}

	static class TimePoint {
		int n;      //time point
		int type;   //left end = 0 or right end = 1
		int buckets;   //# of buckets needed
		
		TimePoint(int a, int b, int c) {
			n = a;
			type = b;
			buckets = c;
		}
	}
}
