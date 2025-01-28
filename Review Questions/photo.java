import java.util.*;
public class photo {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] A = new int[N+1];
		for(int j=1; j<=N; j++)
			A[j] = in.nextInt();
		
		int[] B = new int[N+1];
		for(int j=1; j<=N; j++) 
			B[j] = in.nextInt();
		
		//translate from the old ID to the new ID
		int[] BI = new int[N+1];
		for(int j=1; j<=N; j++)
			BI[ B[j] ] = j; //old ID: B[j];   new ID: j
			
		//now the final lineup has the cows (in new ID): 1, 2, 3, ..., N
		
		//initial lineup (in new ID)
		int[] AI = new int[N+1];
		for(int j=1; j<=N; j++)
			AI[j] = BI[ A[j] ];
		
		int ans = 0; //min number of moves
		int mf = 0; //max prefix
		for(int j=1; j<=N; j++) {
			if(mf > AI[j])
				ans++;
			mf = Math.max(mf, AI[j]);
		}
		
		System.out.println(ans);
		in.close();
	}
}