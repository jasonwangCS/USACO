/*
 * Photo shoot
 */
import java.util.*;
public class photo {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(); //length of input string
		char[] s = in.next().toCharArray();
		
		int ans = 0;  //min # of reversals
		for(int j=N-1; j>=1; j-=2) {
			if(s[j]==s[j-1])
				continue;
			else if(s[j]=='H' && ans%2==0) //state 0
				ans++;
			else if(s[j]=='G' && ans%2==1) //state 1
				ans++;
		}
		
		System.out.println(ans);
		in.close();
	}
}