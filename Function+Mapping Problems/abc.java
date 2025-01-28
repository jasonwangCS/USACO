/*
 * ABC (Dec 2020)
 */
import java.util.*;
public class abc {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int[] A = new int[7]; //read the 7 integers
		for(int j=0; j<7; j++)
			A[j] = in.nextInt();
		Arrays.sort(A);
		
		int a = A[0];
		int b = A[1];
		int c = A[6] - A[0] - A[1];
		
		System.out.println(a + " " + b + " " + c);
		in.close();
	}
}
