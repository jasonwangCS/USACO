/*
 * Rut length (Dec 2020)
 */
import java.util.*;
public class rut {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt(); //# of cows
		int[][] cows = new int[n][5];
		
		int eb = n; //# of east-bound cows
		for(int j=0; j<n; j++) {
			String d = in.next();
			if(d.equals("N")) {
				cows[j][0] = 1;  //east==0;  north==1
				eb--;
			}

			cows[j][1] = in.nextInt();  //x-coordinate
			cows[j][2] = in.nextInt();  //y-coordinate
			cows[j][3] = Integer.MAX_VALUE; //rut length
			cows[j][4] = j; //original cow ID
		}

		//sort the cows by directions (east then north)
		Arrays.sort(cows, (p, q) -> p[0]-q[0]);

		//sort the east-bound cows by ascending y-coordinate
		Arrays.sort(cows, 0, eb, (p, q) -> p[2]-q[2]);
		
		//sort the north-bound cows by ascending x-coordinate
		Arrays.sort(cows, eb, n, (p, q) -> p[1]-q[1]);
		
		for(int i=0; i<eb; i++) { //i east-bound
			for(int j=eb; j<n; j++) { //j north-bound
				//j must be in quadrant IV of i so they may intersect
				int dx = cows[j][1] - cows[i][1];
				int dy = cows[i][2] - cows[j][2]; 
				if(dx>0 && dy>0) {
					if(dx<dy && cows[i][3]>=dx)  //i blocks j
						cows[j][3] = Math.min(cows[j][3], dy);
					
					else if(dy<dx && cows[j][3]>=dy) { //j blocks i
						cows[i][3] = Math.min(cows[i][3], dx);
						break; //after one j blocks i, then no other j's does
					}
				}
			}
		}
		//restore the original cow order
		Arrays.sort(cows, (p, q) -> p[4]-q[4]);
		for(int j=0; j<n; j++) {
			if(cows[j][3]<Integer.MAX_VALUE)
				System.out.println(cows[j][3]);
			else
				System.out.println("Infinity");
		}
		
		in.close();
	}
}
