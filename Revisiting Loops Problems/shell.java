/*
 * Shell (Jan 2019)
 */
import java.util.*;
import java.io.*;
public class shell {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("shell.in"));
		PrintWriter out = new PrintWriter(new File("shell.out"));

		int N = in.nextInt(); //# of swaps
		int[][] swaps = new int[N][3];
		for(int x=0; x<N; x++) {
			swaps[x][0] = in.nextInt(); //the swaps
			swaps[x][1] = in.nextInt();
			swaps[x][2] = in.nextInt(); //Elsie's guesses
		}

		int max = 0;
		for(int j=1; j<=3; j++) {
			//assume the pebble is at position j initially
			int pebble = j;
			
			int count = 0;
			for(int x=0; x<N; x++) {
				//update pebble value if necessary
				if(swaps[x][0]==pebble || swaps[x][1]==pebble)
					pebble = swaps[x][0] + swaps[x][1] - pebble;
				
				if(swaps[x][2]==pebble) count++;
			}

			max = Math.max(max, count);
		}
		
		out.println(max);
		out.close();
		in.close();
	}
}
