/*
 * Transformation
 */
import java.util.*;
public class transform {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(); //size of grid
		
		char[][] A = new char[N][N];
		for(int r=0; r<N; r++)
			A[r] = in.next().toCharArray();
		
		char[][] B = new char[N][N];
		for(int r=0; r<N; r++)
			B[r] = in.next().toCharArray();
		
		int ans = 7;
		if(same(B, t1(A)))
			ans = 1;
		else if(same(B, t2(A)))
			ans = 2;
		else if(same(B, t3(A)))
			ans = 3;
		else {
			char[][] C = t4(A);

			if(same(B, C))
				ans = 4;
			else if(same(B, t1(C)) || same(B, t2(C)) || same(B, t3(C)))
				ans = 5;
			else if(same(B, A))
				ans = 6;
		}
		System.out.println(ans);
		in.close();
	}
	
	static char[][] t1(char[][] A) { //rotate 90 clockwise
		int N = A.length;
		char[][] B = new char[N][N];
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				B[c][N-1-r] = A[r][c];
			}
		}
		
		return B;
	}
	
	static char[][] t2(char[][] A) { //rotate 180 clockwise
		return t1(t1(A));
	}
	
	static char[][] t3(char[][] A) { //rotate 270 clockwise
		return t1(t2(A));
	}
	
	static char[][] t4(char[][] A) { //reflect around vertical line of symmetry
		int N = A.length;
		char[][] B = new char[N][N];
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++)
				B[r][N-1-c] = A[r][c];
		}
		return B;
	}
	
	static boolean same(char[][] A, char[][] B) {
		//assuming A and B have the same dimensions
		for(int r=0; r<A.length; r++) {
			for(int c=0; c<A[r].length; c++) {
				if(A[r][c]!=B[r][c])
					return false;
			}
		}
		return true;
	}
}