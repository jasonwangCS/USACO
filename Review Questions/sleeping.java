import java.util.*;
public class sleeping {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt(); //# of integers
		int[] A = new int[N];

		long s0 = 0; //total sum of A[0...N-1]
		for(int j=0; j<N; j++) {
			A[j] = in.nextInt();
			s0 += A[j];
		}
		
		//check for the first s1 = A[0] + ... + A[j]
		//  so that s1 | s0 and A[j+1...N-1] can be partitioned into segments
		//  where each segment has sum s1.
		long s1 = 0;
		for(int j=0; j<N; j++) {
			//for(int k=0; k<=j; k++)
			//	s1 += A[k];
			s1 += A[j];
			
			if(s1==0 && s0==0 || s1!=0 && s0%s1==0) {
				int steps = partition(A, j+1, s1);
				if(steps>=0) {
					System.out.println(j+steps);
					break;
				}
			}
		}
		
		in.close();
	}
	
	//return # of modifications to partition the A[x...N-1] into segments
	//  of equal sum; if impossible, return -1.
	static int partition(int[] A, int x, long s1) {
		int steps = 0;
		int N = A.length;
		while(x<N) {
			long s2 = A[x];
			int y = x+1;
			while(y<N && s2<s1) {
				s2 += A[y];
				y++;
			}
		
			//s2 = A[x] + ... + A[y-1]; s2 lags behind y by one position
			if(s2==s1) {
				steps += y-1 - x;
				x = y;
			}
			else
				return -1;
		}
		
		return steps;
	}
}