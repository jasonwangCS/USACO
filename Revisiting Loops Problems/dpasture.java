/*
 * Diamond pasture II
 */
import java.util.*;
public class dpasture {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(); //# of rows
		int M = in.nextInt(); //# of columns
		int Q = in.nextInt(); //# of queries
		int[][] grid = new int[N][M];
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++)
				grid[r][c] = in.nextInt();
		}

		for(int q=0; q<Q; q++) {
			int r0 = in.nextInt()-1; //center
			int c0 = in.nextInt()-1;
			int d0 = in.nextInt()/2; //radius
			
			int sum = 0; //sum of tasteness in or on the diamond pasture
			for(int r=r0-d0; r<=r0+d0; r++) {
				int s = d0-Math.abs(r-r0);
				for(int c=c0-s; c<=c0+s; c++)
					sum += grid[r][c];
			}
			System.out.println(sum);
		}
		
		in.close();
	}
}