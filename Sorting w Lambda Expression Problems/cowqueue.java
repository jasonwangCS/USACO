/*
 * Cows cross road III (Bronze Feb 2017)
 * 
 * Use 2D array instead of a helper class to sort.
 */
import java.util.*;
import java.io.*;
public class cowqueue {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("cowqueue.in"));
		PrintWriter out = new PrintWriter(new File("cowqueue.out"));

		int N = in.nextInt();   //# of cows
		int[][] cows = new int[N][2];
		for(int k=0; k<N; k++) {
			cows[k][0] = in.nextInt();  //arrival time
			cows[k][1] = in.nextInt();  //processing time
		}
		
		//sort the cows by arrival time (ascending order)
		Arrays.sort(cows, (c1, c2) -> c1[0]-c2[0]);
		
		//process the cows
		int ft = 0;  //finishing time of the previous cow
		for(int k=0; k<N; k++) {
			if(cows[k][0] < ft)
				ft += cows[k][1];
			else
				ft = cows[k][0] + cows[k][1];
		}
		
		//approach 2:
		//cows[0][1] += cows[0][0];
		//for(int k=1; k<N; k++) {
		//	if(cows[k][0] < cows[k-1][1])
		//		cows[k][1] += cows[k-1][1];
		//	else
		//		cows[k][1] += cows[k][0];
		//}
		//out.println(cows[N-1][1]);
		
		out.println(ft);
		out.close();
		in.close();
	}
}
