/*
 * Rotate array
 */
import java.util.*;
public class rotate {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt() % n;
		
		int[] A = new int[n];
		for(int j=0; j<n; j++)
			A[j] = in.nextInt();

		if(k>0) {
			reverse(A, 0, n-1);
			reverse(A, 0, k-1); //the last k integers are at the front
			reverse(A, k, n-1);
		}
		
        for(int x : A)
        	System.out.print(x + " ");
		System.out.println();
		in.close();
	}
	
	static void reverse(int[] A, int low, int high) {
		//for(int j=0; j<(high-low+1)/2; j++) {
		//	int tmp = A[low+j];
		//	A[low+j] = A[high-j];
		//	A[high-j] = tmp;
		//}
		for(int j=0; low+j<high-j; j++) {
			int tmp = A[low+j];
			A[low+j] = A[high-j];
			A[high-j] = tmp;
		}
	}
}