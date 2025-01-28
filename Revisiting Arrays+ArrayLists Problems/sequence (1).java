/*
 * Longest consecutive sequence
 */
import java.util.*;
public class sequence {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(); //# of integers
		int[] A = new int[N];
		for(int j=0; j<N; j++)
			A[j] = in.nextInt();
		
		Arrays.sort(A); //sort all integers in A in ascending order
		
		//find the longest clump of consecutive sequence
		int maxLen = 1;
		for(int j=0; j<N; ) {
			int k = j+1;
			int len = 1;
			while(k<N) {
				if(A[k]==A[k-1]+1) {
					len++;
					k++;
				}
				else if(A[k]==A[k-1]) {
					//do nothing; ignore the duplicates
				}
				else //(A[k]>A[k-1]+1)
					break;
			}
			//k is first index not in the current clump
			maxLen = Math.max(maxLen, len);
			j=k;
		}
		System.out.println(maxLen);
		in.close();
	}
}