/*
 * Factory (Mar 2019)
 */
import java.util.*;
import java.io.*;
public class factory {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("factory.in"));
		PrintWriter out = new PrintWriter(new File("factory.out"));
		
		int N = in.nextInt();  //# of stations
		int[] incoming = new int[N];
		int[] outgoing = new int[N];
		
		for(int j=0; j<N-1; j++) {
			int x = in.nextInt()-1;
			int y = in.nextInt()-1;
			outgoing[x]++; //going out
			incoming[y]++; //going in
		}

		int station = -1;

		//check if there is a unique node j with outgoing[j]==0
		for(int j=0; j<N; j++) {
			if(outgoing[j]==0) {
				if(station!=-1) {
					station = -1;
					break;
				}
				else //station===-1
					station = j+1;
			}
		}
		
		out.println(station);
		out.close();
		in.close();
	}
}
