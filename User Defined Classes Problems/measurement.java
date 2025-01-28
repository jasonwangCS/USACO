/*
 * Measurement (Dec 2017)
 */
import java.util.*;
import java.io.*;
public class measurement {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("measurement.in"));
		PrintWriter out = new PrintWriter(new File("measurement.out"));

		int n = in.nextInt();  //number of records
		Record[] records = new Record[n];
		for(int i=0; i<n; i++) {
			records[i] = new Record(in.nextInt(), in.next().substring(0, 1), 
					in.nextInt());
		}

		//sort the records by increasing days
		Arrays.sort(records, (x, y) -> x.day-y.day);
		
		//For each day, find the cows with highest milk production;
		//  compare this against the previous day. If there is any change, 
		//  increase the counter by 1.
		int count = 0;
		int[] milkProd = new int[3];
		boolean[] isHighest = new boolean[3];

		Arrays.fill(milkProd, 7); // initially each cow has milk production 7
		Arrays.fill(isHighest, true); // initially each has highest production
		
		for(int i=0; i<n; i++) {
			if(records[i].name.equals("B")) 
				milkProd[0] += records[i].change;

			else if (records[i].name.equals("E")) 
				milkProd[1] += records[i].change;
			
			else
				milkProd[2] += records[i].change;
			
			int max = Math.max(milkProd[0], Math.max(milkProd[1], milkProd[2]));
			
			boolean h0 = (milkProd[0]==max);
			boolean h1 = (milkProd[1]==max);
			boolean h2 = (milkProd[2]==max);
			
			if(h0!=isHighest[0] || h1!=isHighest[1] || h2 !=isHighest[2]) {
				count++;
			}
			isHighest[0] = h0;
			isHighest[1] = h1;
			isHighest[2] = h2;
		}
		
		// write count to the output
		out.println(count);
		out.close();
		in.close();
	}

	//helper class for a record
	static class Record {
		int day;
		String name;
		int change;

		Record(int a, String b, int c) {
			day = a;
			name = b;
			change = c;
		}
	}
}
