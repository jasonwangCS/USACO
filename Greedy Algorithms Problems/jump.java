/*
 * Jump game
 */
import java.util.*;
public class jump {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(); //# of integers
		int[] A = new int[N];
		for(int j=0; j<N; j++)
			A[j] = in.nextInt();

		int reach = 0;
		boolean ans = true;
		for(int j=0; j<N; j++) {
			if(reach<j) {
				ans = false;
				break;
			}
			
			reach = Math.max(reach, j + A[j]);
		}
		System.out.println(ans);
		in.close();
	}
}