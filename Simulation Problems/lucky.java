/*
 * Lucky person
 */
import java.io.*;
import java.util.*;
public class lucky {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt(); //# of people
		int[] A = new int[N-1];
		for(int j=0; j<N-1; j++)
			A[j] = in.nextInt();
		in.close();
		
		LinkedList<Integer> remaining = new LinkedList<Integer>();
		for(int k=2; k<=N; k++)
			remaining.add(k);
		remaining.add(1);
		
		for(int j=0; j<N-1; j++) {
			//remove the element at position A[j]-1
			for(int k=0; k<A[j]-1; k++) {
				remaining.add(remaining.removeFirst());
			}
			remaining.removeFirst();
		}

		System.out.println(remaining.getFirst());
	}
}
