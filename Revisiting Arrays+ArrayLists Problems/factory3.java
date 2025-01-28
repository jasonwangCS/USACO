import java.util.*;
import java.io.*;
public class factory3 {
	static int N;
	static boolean[][] outgoing;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("factory.in"));
		PrintWriter out = new PrintWriter(new File("factory.out"));
		
		N = in.nextInt();  //# of stations
		outgoing = new boolean[N][N];
		
		for(int j=0; j<N-1; j++) {
			int x = in.nextInt()-1;
			int y = in.nextInt()-1;
			outgoing[y][x] = true;   //reverse belt x->y
		}

		int station = -1;

		//check if possible to go from station "x" to all others
		for(int x=0; x<N; x++) {
			visited = new boolean[N];
			trace(x);
			
			int count = 0;
			for(int y=0; y<N; y++)
				if(visited[y]) count++;
			
			if(count==N) {
				station = x+1;
				break;
			}
		}
		
		out.println(station);
		out.close();
		in.close();
	}
	
	static void trace(int x) {
		visited[x] = true;
		for(int y=0; y<N; y++) {
			if(!visited[y] && outgoing[x][y])
				trace(y);
		}
	}
}
