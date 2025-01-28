/*
 * Two piles with A and B coins are given. On each move, we can either 
 * remove one coin from the left pile and two coins from the right pile, 
 * or two coins from the left pile and one coin from the right pile.
 * Report if we can empty both the piles.
 */
import java.io.*;
import java.util.*;
public class piles {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //# of tests

		for(int j=0; j<n; j++) { //for each test
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(2*a>=b && 2*b>=a && (a+b)%3==0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		br.close();
	}
}
