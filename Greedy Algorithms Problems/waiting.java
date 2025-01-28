/*
 * Average waiting time
 */
import java.util.*;
public class waiting {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(); //# of customers
		int[][] A = new int[N][2];
		for(int j=0; j<N; j++) {
			A[j][0] = in.nextInt(); //arrival time
			A[j][1] = in.nextInt(); //preparation time
		}
		in.close();
		
		int at = 0; //available time
		long total = 0; //total waiting time
		for(int j=0; j<N; j++) {
			if(A[j][0]>=at) { //no extra waiting
				total += A[j][1];
				at = A[j][0] + A[j][1];
			}
			else { //wait till the previous customer is done
				total += at - A[j][0] + A[j][1];
				at += A[j][1];
			}
		}
		
		System.out.println(1000L*total/N);
	}
}