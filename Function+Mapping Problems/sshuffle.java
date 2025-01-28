/*
 * After K rounds of shuffle, find the # of integers go back to the 
 * original positions, and find the # of empty positions. 
 */
import java.util.*;
import java.io.*;
public class sshuffle {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();   //# of integers
		int K = in.nextInt();   //# of rounds of shuffle

		int[] A = new int[N+1]; //rule of shuffle
		for(int j=1; j<=N; j++)
			A[j] = in.nextInt(); //cow at position j goes to position A[j]

		int[] B = new int[N+1]; //B[p]: cow at position p after K rounds of shuffle

		int count1 = 0;  //# of integers go back to original positions
		for(int v=1; v<=N; v++) { //shuffle K times
			int p = v; //current position of value v
			for(int x=0; x<K; x++) {
				p = A[p];
			}
			B[p] = v;  //v is at position p
			if(B[p]==p) count1++;
		}
		
		int count2 = 0;  //# of positions with no integers 
		for(int p=1; p<=N; p++) {
			if(B[p]==0) count2++;
		}
		
		System.out.println(count1 + " " + count2);
		in.close();
	}
}
