/*
 * Partition array
 */
import java.util.*;
public class partition {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(); //# of integers
		int T = in.nextInt(); //target value

		int[] A = new int[N];
		for(int j=0; j<N; j++)
			A[j] = in.nextInt();
		
		int i = 0;
		while(i<N) {
			if(A[i]!=T) {
				i++;
				continue;
			}
			
			//found a new block of T
			int j = i;
			while(j<N && A[j]==T)
				j++;
			
			//A[i...j-1] is the current block of T
			System.out.print(j-i + " "); //length

			i = j;
		}
		System.out.println();

		//show gaps
		int prev = -1; //previous location of T
		for(int j=0; j<N; j++) {
			if(A[j]==T) {
				System.out.print(j-prev-1 + " ");
				prev = j;
			}
		}
		System.out.println(N-prev-1); //final gap
		
		in.close();
	}
}