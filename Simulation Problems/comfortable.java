/*
 * Comfortable cows (Feb 2021)
 */
import java.io.*;
import java.util.*;
public class comfortable {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(); //# of cows
		
		//occupied[i][j]==true iff there is a cow at (i,j)
		boolean[][] occupied = new boolean[1001][1001];

		//nbors[i][j]: # of cow neighbors for the spot at (i,j)
		int[][] nbors = new int[1001][1001];
		
		//type[p]: # of cows having p neighbors
		int[] type = new int[5];
		
		for(int j=0; j<N; j++) {
			int x = in.nextInt();
			int y = in.nextInt();
			occupied[x][y] = true;
			
			int myNbors = 0;
			//consider the 4 neighbors
			if(x+1<=1000 && occupied[x+1][y]) { //east
				myNbors++;
				type[nbors[x+1][y]]--;
				nbors[x+1][y]++;
				type[nbors[x+1][y]]++;
			}

			if(x-1>=0 && occupied[x-1][y]) { //west
				myNbors++;
				type[nbors[x-1][y]]--;
				nbors[x-1][y]++;
				type[nbors[x-1][y]]++;
			}

			if(y+1<=1000 && occupied[x][y+1]) { //north
				myNbors++;
				type[nbors[x][y+1]]--;
				nbors[x][y+1]++;
				type[nbors[x][y+1]]++;
			}
		
			if(y-1>=0 && occupied[x][y-1]) { //south
				myNbors++;
				type[nbors[x][y-1]]--;
				nbors[x][y-1]++;
				type[nbors[x][y-1]]++;
			}

			type[myNbors]++;
			nbors[x][y] = myNbors;
			System.out.println(type[3]);
		}
		in.close();
	}
}
