/*
 * Buy and sell
 */
import java.util.*;
public class buysell {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(); //# of integers
		int[] P = new int[N];
		for(int j=0; j<N; j++)
			P[j] = in.nextInt();
		
		int sum = 0;
        for(int j=1; j<P.length; j++) {
            if(P[j]>P[j-1])
                sum += P[j]-P[j-1];
        }
        System.out.println(sum);

		in.close();
	}
}