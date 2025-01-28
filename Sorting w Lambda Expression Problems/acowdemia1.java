/*
 * Acowdemia I (Mar 2021)
 */
import java.io.*;
import java.util.*;
public class acowdemia1 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(); //# of integers
		int L = in.nextInt(); //# of max citations in survey
		
		int[] C = new int[N+1];
		for(int j=1; j<=N; j++)
			C[j] = in.nextInt();
		in.close();
		
		Arrays.sort(C);

		//A[x]: # of times integer x appears in C
		int[] A = new int[100_001];
		for(int j=1; j<=N; j++)
			A[C[j]]++;
		
		int maxH = 0;
		for(int j=1; j<=N; j++)
			maxH = Math.max(maxH, Math.min(C[j], N-j+1));

		if(L>0) {
			for(int j=1; j<=N; j++) {
				//add 1 to C[j] ... C[j+L-1]
				int tmp;
				if(L>=A[C[j]])
					tmp = Math.min(C[j]+1, N-j+1);
				else //L < A[C[j]]
					tmp = Math.min(C[j]+1, N-j+1 - (A[C[j]]-L));
				maxH = Math.max(maxH, tmp);
			}
		}
		System.out.println(maxH);
	}
}
