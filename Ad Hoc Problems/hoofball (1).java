/*
 * From each cow if not been visited, a new ball is requested; 
 * save the path that the ball can travel using an ArrayList.
 */
import java.io.*;
import java.util.*;
public class hoofball {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("hoofball.in"));
		PrintWriter out = new PrintWriter(new File("hoofball.out"));
		
		int N = in.nextInt();     //number of cows
		int[] A = new int[N];
		for(int j=0; j<N; j++)
			A[j] = in.nextInt();
		
		Arrays.sort(A);  //sort the cows in ascending order
		
		boolean[] visited = new boolean[N];  //if a cow has been visited
		boolean[] isHead = new boolean[N];   //if a cow is head of a path
	
		for(int j=0; j<N; j++) {
			if(visited[j]) continue;

			//cows in the current path
			ArrayList<Integer> AL = new ArrayList<Integer>();
			
			isHead[j] = true;
			visited[j] = true;
			AL.add(j);
			
			int c = j;  //current cow with the ball
			while(true) {
				//decide the neighbor to pass the ball
				int neighbor = c+1;
				if(c==N-1 || c>0 && A[c]-A[c-1] <= A[c+1]-A[c])
					neighbor = c-1;

				if(!AL.contains(neighbor)) { //continue current path
					AL.add(neighbor); 
					visited[neighbor] = true;
					c = neighbor;
				}
				else 
					break;
			}

			//mark any cow other than the head in the path as non-head
			for(int k=1; k<AL.size(); k++) {
				if(isHead[AL.get(k)])
					isHead[AL.get(k)] = false;
			}
		}
		
		int count=0;
		for(int k=0; k<N; k++) {
			if(isHead[k]) {
				count++;
			}
		}
		
		out.println(count);
		out.close();
		in.close();
	}
}
