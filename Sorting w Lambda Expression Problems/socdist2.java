/*
 * Social distance II (Mar 2020)
 */
import java.util.*;
import java.io.*;
public class socdist2 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("socdist2.in"));
		PrintWriter out = new PrintWriter(new File("socdist2.out"));

		int N = in.nextInt(); //# of cows
		int[][] cows = new int[N][2];
		for(int j=0; j<N; j++) {
			cows[j][0] = in.nextInt();  //location of cow j
			cows[j][1] = in.nextInt();  //whether cow j is sick
		}
		
		//sort cows by increasing locations
		Arrays.sort(cows, (x, y) -> x[0] - y[0]);
		
		//Find the min distance between a healthy cow and a sick neighbor cow:
		// If distance between two cows is < R, then disease spreads.
		int R = 1_000_000;
		for(int j=0; j<N; j++) {
			if(cows[j][1] == 0) { //cow j is healthy
				if(j-1>=0 && cows[j-1][1]==1)
					R = Math.min(R, cows[j][0]-cows[j-1][0]);
	
				if(j+1<N && cows[j+1][1]==1)
					R = Math.min(R, cows[j+1][0]-cows[j][0]);
			}
		}

		//find the min # of cows initially sick
		int count = 0;
		if(cows[0][1]==1) count = 1;
		
		for(int j=1; j<N; j++) {
			if(cows[j][1]==1) {
				if(cows[j-1][1]==1 && cows[j][0]-cows[j-1][0]>=R)
					count++;
				else if(cows[j-1][1]==0)
					count++;
			}
		}
		
		out.println(count);
		in.close();
		out.close();
	}
}
