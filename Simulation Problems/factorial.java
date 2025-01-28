/*
 * Clumsy factorial
 */
import java.util.*;
public class factorial {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		while(T>0) {
			int N = in.nextInt();
			System.out.println(solve(N));
			T--;
		}
		in.close();
	}
	
	static int solve(int N) {
		if(N==1) return 1; //1
		if(N==2) return 2; //2*1
		if(N==3) return 6; //3*2/1
		//N*(N-1)/(N-2)+(N-3) - (N-4)*(N-5)/(N-6)+(N-7) - ...
		
		int ans = N*(N-1)/(N-2)+(N-3);

		int x=N-4;
		for(; x>=4; x-=4)
			ans = ans - x*(x-1)/(x-2)+(x-3);

		if(x==3)
			ans = ans - 3*2/1;
		else if(x==2)
			ans = ans - 2*1;
		else if(x==1)
			ans = ans - 1;
		return ans;
	}
}