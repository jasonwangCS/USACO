/*
 * Sleepy cows (Jan 2019)
 */
import java.util.*;
import java.io.*;
public class sleepy {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("sleepy.in"));
		PrintWriter out = new PrintWriter(new File("sleepy.out"));

		int N = in.nextInt();  //# of cows
		int[] cows = new int[N];
		for(int j=0; j<N; j++)
			cows[j] = in.nextInt();

		int x;
		for(x=N-2; x>=0; x--) {
			if(cows[x]>cows[x+1])
				break;
		}
		//cows[x+1] ... cows[N-1] are sorted in ascending order
		
		out.println(x+1);
		out.close();
		in.close();
	}
}
