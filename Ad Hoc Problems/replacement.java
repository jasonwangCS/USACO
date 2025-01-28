/*
 * Integer replacement
 */
import java.util.*;
public class replacement {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		in.close();
		
        System.out.println(solve(N));
	}
	
	static int solve(int n) {
        if(n%2==0) return 1+solve(n/2);

        if(n==1) return 0; //base case 1
        if(n==3) return 2; //base case 3
        
        if(n%4==1) 
        	return 1+solve(n-1);
        else
        	return 1+solve(n+1);
    }
}