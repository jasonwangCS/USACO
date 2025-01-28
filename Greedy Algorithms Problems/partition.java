/*
 * Partition labels
 */
import java.util.*;
public class partition {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String str = in.next();
		int[] A = new int[str.length()];
		for(int j=0; j<str.length(); j++)
			A[j] = str.charAt(j) - 'a';

		int[] last = new int[26];  //last occurrence of each letter
		//Arrays.fill(last, -1);

		for(int j=0; j<A.length; j++)
			last[A[j]] = j;

		int left = 0;  //left end of the current part
		int right = last[A[0]]; //right end of the current part
		for(int j=0; j<A.length; j++) {
			if(j>right) { //a new part
				System.out.print(right-left+1 + " ");
				left = j;
				right = last[A[j]];
			}
			else { //j<=right
				right = Math.max(right, last[A[j]]);
			}
		}
		System.out.println(right-left+1);
		in.close();
	}
}