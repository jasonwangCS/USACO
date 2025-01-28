/*
 * Circular barn (Feb 2016)
 */
import java.io.*;
import java.util.*;
public class cbarn {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("cbarn.in"));
		PrintWriter out = new PrintWriter(new File("cbarn.out"));
		
		int n = in.nextInt(); //# of rooms
		int[] room = new int[n];  //# of cows in each room
		for(int i=0; i<n; i++) {
			room[i] = in.nextInt();
		}

		//Open the door of barn room[i]
		int minDist = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			//start from room i, 
			//room i,   room[i] cows stay here; steps required = 0
			//room i+1, room[i+1] cows stay here; steps required = room[i+1]*1
			//room i+2, room[i+2] cows stay here; steps required = room[i+2]*2
			//and so on
			int sum = 0;
			for(int j=0; j<n; j++) {
				sum = sum + room[(i+j)%n] * j;
			}

			if(sum < minDist)
				minDist = sum;
		}

		out.println(minDist);
		out.close();
		in.close();
	}
}
