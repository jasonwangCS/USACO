/*
 * broken necklace 
 */
import java.util.*;
public class necklace {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt(); // length of string
		String str = in.next();
		String s2 = str + str;
		
		//right[j]=y-j where y is the max index so str[j...y-1] that are the same
		//left[j]=j-x where x is the min index so str[x+1...j] that are the same
		int[] right = new int[N];
		int[] left = new int[N];

		for(int j=0; j<N; j++) {
			char first = s2.charAt(j);  //first bead that is not 'w'
			int y=j;
			while(y<j+N) {
				if(s2.charAt(y)=='w') 
					y++;
				else if(first=='w') {
					first = s2.charAt(y); 
					y++;
				}
				else if(s2.charAt(y)==first) 
					y++;
				else 
					break;
			}
			right[j] = y-j; //max length of clump to the right of j
		}

		for(int j=N; j<2*N; j++) {
			char first = s2.charAt(j);
			int x = j;
			while(x>j-N) {
				if(s2.charAt(x)=='w') 
					x--;
				else if(first=='w') {
					first = s2.charAt(x); 
					x--;
				}
				else if(s2.charAt(x)==first) 
					x--;
				else 
					break;
			}
			left[j-N] = j-x; //max length of clump to the left of j
		}
		
		int ans = 2;
		for(int j=0; j<N; j++) {
			ans = Math.max(ans, right[j] + left[(j-1+N)%N]);
			ans = Math.min(ans, N);
		}
		System.out.println(ans);
		in.close();
	}
}
