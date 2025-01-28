/*
 * Bull in China shop (Mar 2016)
 */
import java.util.*;
import java.io.*;
public class bcs {
	static int N;
	static int K;
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("bcs.in"));
		PrintWriter out = new PrintWriter(new File("bcs.out"));
		N = in.nextInt();
		K = in.nextInt();
		
		int[][] target = new int[N][N];  //the target to recovered
		for(int x=0; x<N; x++) {
			String line = in.next();
			for(int y=0; y<N; y++) {
				char c = line.charAt(y);
				if(c=='#')
					target[x][y] = 1;
			}
		}
		
		int[][][] pics = new int[K][N][N];  //the k pieces
		for(int p=0; p<K; p++) {
			for(int x=0; x<N; x++) {
				String line = in.next();
				for(int y=0; y<N; y++) {
					char c = line.charAt(y);
					if(c=='#')
						pics[p][x][y] = 1;
				}
			}
		}
		in.close();

		//shift all pieces to the upper-most and left-most position
		for(int p=0; p<K; p++) {
			boolean tf;
			do {
				tf = shiftH(pics[p], 'W');
			} while(tf);
	
			do {
				tf = shiftV(pics[p], 'N');
			} while(tf);
		}
		
		//for every two pieces, try shift and glue together
		for(int p=0; p<K; p++) {
			int[][] A0 = add(new int[N][N], pics[p]); //copy piece p to A0
			
			for(int e1=0; e1<N; e1++) {
				int[][] A = add(new int[N][N], A0); //copy A0 to A1
				for(int s1=0; s1<N; s1++) {
					
					for(int q=p+1; q<K; q++) { 
						int[][] B0 = add(new int[N][N], pics[q]); //copy piece q to B0

						for(int e2=0; e2<N; e2++) {
							int[][] B = add(new int[N][N], B0); //copy B0 to B1

							for(int s2=0; s2<N; s2++) {
								int[][] C = add(A, B); //add A to B
								if(same(C, target)) {
									out.println((p+1) + " " + (q+1));
									out.close();
									return;
								}
								if(!shiftV(B, 'S')) break; //shift B1 to south
							}
							if(!shiftH(B0, 'E')) break; //shift B0 to east
						}
					}
					if(!shiftV(A, 'S')) break; //shift A1 to south
				}
				if(!shiftH(A0, 'E')) break; //shift A0 to east
			}
		}
	}
	
	//shift west (if d='W') or east (if d='E')
	static boolean shiftH(int[][] A, char d) {
		//check whether shift to west or east is possible
		int b = (d=='W' ? 0 : N-1);  //boundary column
		int dc = (d=='W' ? 1 : -1);  //delta_c
		for(int r=0; r<N; r++) {
			if(A[r][b]==1)
				return false; //can't shift along direction d
		}

		//shift to west side or east side
		for(int r=0; r<N; r++) {
			for(int x=0; x<N-1; x++)
				A[r][b+dc*x] = A[r][b+dc*(x+1)];
			A[r][b+dc*(N-1)] = 0;
		}
		return true;
	}

	//shift north (if d='N') or south (if d='S')
	static boolean shiftV(int[][] A, char d) {
		//check whether shift to north or south is possible
		int b = (d=='N' ? 0 : N-1); //boundary row
		int dr = (d=='N' ? 1 : -1); //delta_r
		for(int c=0; c<N; c++) {
			if(A[b][c]==1)
				return false;  //can't shift along direction d
		}

		//shift to north side or south side
		for(int c=0; c<N; c++) {
			for(int x=0; x<N-1; x++)
				A[b+dr*x][c] = A[b+dr*(x+1)][c];
			A[b+dr*(N-1)][c] = 0;
		}
		
		return true;
	}

	//whether two arrays are the same
	static boolean same(int[][] A, int[][] B) {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(A[r][c]!=B[r][c])
					return false;
			}
		}
		return true;
	}

	//return the sum of two arrays
	static int[][] add(int[][] A, int[][] B) {
		int[][] C = new int[N][N];
		for(int r=0; r<N; r++)
			for(int c=0; c<N; c++)
				C[r][c] = A[r][c] + B[r][c];
		return C;
	}
}
