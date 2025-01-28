/*
 * Acowdemia II (Mar 2021)
 */
import java.io.*;
import java.util.*;
public class acowdemia2 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int K = in.nextInt(); //# of papers
		int N = in.nextInt(); //# of people
		
		//all names in given order and sorted order
		ArrayList<String> names = new ArrayList<>();
		ArrayList<String> sorted = new ArrayList<>();
		for(int j=0; j<N; j++) {
			String person = in.next();
			names.add(person);
			sorted.add(person);
		}
		Collections.sort(sorted);

		//ans[i][j]==0 if i is more junior than j; 1 more senior
		//          -1 if not clear
		int[][] ans = new int[N][N];
		for(int r=0; r<N; r++)
			Arrays.fill(ans[r], -1);

		for(int u=0; u<K; u++) {
			int[] id = new int[N]; //index in "names"
			int[] order = new int[N]; //location in "namesSorted"
			for(int j=0; j<N; j++) {
				String person = in.next();
				id[j] = names.indexOf(person);
				order[j] = sorted.indexOf(person);
			}
			
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					if(order[i]>order[j]) { //person @ i is more junior than person @ j
						//any person before i is more junior than any one after j
						for(int x=0; x<=i; x++) { 
							for(int y=j; y<N; y++)
								ans[id[x]][id[y]] = 0;
						}
					}
				}
			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int x=0; x<N; x++) {
					if(ans[i][x]==0 && ans[x][j]==0) ans[i][j] = 0;
				}
			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i==j)
					System.out.print('B');
				else if(ans[i][j]==0)
					System.out.print(0);
				else if(ans[j][i]==0)
					System.out.print(1);
				else
					System.out.print('?');
			}
			System.out.println();
		}
		in.close();
	}
}
