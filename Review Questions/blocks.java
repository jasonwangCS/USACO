/*
 * Blocks (Feb 2022)
 */
import java.util.*;
public class blocks {

	static int[][] perms = { //permutations of the 4 blocks
		{0,1,2,3}, {0,1,3,2}, {0,2,1,3}, {0,2,3,1}, {0,3,1,2}, {0,3,2,1},
		{1,0,2,3}, {1,0,3,2}, {1,2,0,3}, {1,2,3,0}, {1,3,0,2}, {1,3,2,0},
		{2,0,1,3}, {2,0,3,1}, {2,1,0,3}, {2,1,3,0}, {2,3,0,1}, {2,3,1,0},
		{3,0,1,2}, {3,0,2,1}, {3,1,0,2}, {3,1,2,0}, {3,2,0,1}, {3,2,1,0}
	};
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(); //# of words to be spelled
		
		int[][] blocks = new int[4][26];
		for(int j=0; j<4; j++) {
			String line = in.next();
			for(int k=0; k<line.length(); k++) {
				int id = line.charAt(k)-'A';
				blocks[j][id] = 1;
			}
		}
		
		for(int j=0; j<N; j++) {
			String word = in.next();
			
			boolean success = false;
			for(int[] p : perms) {
				//can the 4 blocks in order p spell word?
				success = true;
				for(int x=0; x<word.length(); x++) {
					int id = word.charAt(x)-'A';
					if(blocks[p[x]][id]==0) {
						success = false;
						break;
					}
				}
				if(success) break;
			}
			System.out.println(success ? "YES" : "NO");
		}
		in.close();
	}
}