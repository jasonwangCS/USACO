/*
 * Revegetate (Feb 2019)
 * 
 * If there is an edge between pasture i and pasture j, and i < j, then 
 * pasture j should NOT take the grass type of pasture i.
 */
import java.util.*;
import java.io.*;
public class revegetate {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("revegetate.in"));
		PrintWriter out = new PrintWriter(new File("revegetate.out"));

		int N = in.nextInt();  //# of pastures
		int M = in.nextInt();  //# of cows

		int[][] adj = new int[N][N];
		for(int j=0; j<M; j++) {
			int a = in.nextInt()-1;
			int b = in.nextInt()-1;
			adj[a][b] = 1;
			adj[b][a] = 1;
		}

		//type[r]: final type of pasture r
		int[] type = new int[N];
		
		//allowed[r][j]: whether pasture r can take type j, j>0
		boolean[][] allowed = new boolean[N][5];
		for(int r=0; r<N; r++)
			Arrays.fill(allowed[r], true);
		
		for(int r=0; r<N; r++) {
			if(type[r]==0) { //type has not been decided 
				if(allowed[r][1]) 
					type[r] = 1;
				else if(allowed[r][2]) 
					type[r] = 2;
				else if(allowed[r][3]) 
					type[r] = 3;
				else 
					type[r] = 4;
			}

			int d = type[r];
			for(int c=r+1; c<N; c++) {
				if(adj[r][c]!=0)   //edge between r & c
					allowed[c][d] = false;   //pasture c can NOT be type d
			}
		}

		for(int r=0; r<N; r++) {
			out.print(type[r]);
		}
		out.println();
		out.close();
		in.close();
	}
}
