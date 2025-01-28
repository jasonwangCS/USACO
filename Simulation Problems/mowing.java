/*
 * Mowing (Jan 2016)
 * 
 * Record the last time (time stamp) each tile has been last visited.
 * Find the minimum of such gap and report this min value.
 */
import java.util.*;
import java.io.*;
public class mowing {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("mowing.in"));
		PrintWriter out = new PrintWriter(new File("mowing.out"));
		
		int N = in.nextInt();  //# of lines to be read

		int[][] timeStamps = new int[N*20+1][N*20+1];
		int[] dx = {1, -1, 0,  0};
		int[] dy = {0,  0, 1, -1};
		
		int currTime = 1; //current time
		int cx = N*10;    //current position (cx, cy)
		int cy = N*10;
		int minDiff = Integer.MAX_VALUE;
		for(int k=0; k<N; k++) {  //for each line (direction & steps)
			char dir = in.next().charAt(0);  //direction
			int steps = in.nextInt();
			
			int id;
			if(dir=='E')      id = 0;
			else if(dir=='W') id = 1;
			else if(dir=='N') id = 2;
			else              id = 3;

			for(int j=0; j<steps; j++) { //the steps
				cx += dx[id];
				cy += dy[id];
				
				if(timeStamps[cx][cy]>0)
					minDiff = Math.min(minDiff, currTime - timeStamps[cx][cy]);
				timeStamps[cx][cy] = currTime;
				currTime++;
			}
		}
		
		if(minDiff == Integer.MAX_VALUE)
			minDiff = -1;
		out.println(minDiff);
		out.close();
		in.close();
	}
}
