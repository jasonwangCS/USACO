/*
 * Hoof ball (Feb 2018)
 * 
 * From each cow not been visited, a new ball is requested; 
 * save the path that the ball can travel using an ArrayList.
 */
import java.io.*;
import java.util.*;
public class hoofball {
	static int N;
	static int[] arr;
	static boolean[] visited;
	static boolean[] isHead;
	static int[] nextNode;
	static int currentHead;
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("hoofball.in"));
		PrintWriter out = new PrintWriter(new File("hoofball.out"));
		
		N = in.nextInt(); //number of cows
		arr = new int[N];
		for(int j=0; j<N; j++)
			arr[j]=in.nextInt();
		
		Arrays.sort(arr);  //sort the cows by ascending order
		
		nextNode = new int[N];
		nextNode[0] = 1;
		nextNode[N-1] = N-2;
		for(int j=1; j<N-1; j++) {
			nextNode[j] = j+1;
			if(arr[j]-arr[j-1] <= arr[j+1]-arr[j])
				nextNode[j] = j-1;
		}
		
		visited = new boolean[N];  //if a cow has been visited
		isHead = new boolean[N];   //if a cow is head of a path
		Arrays.fill(isHead, true);
		
		for(int j=0; j<N; j++) {
			if(!visited[j]) {
				currentHead = j;
				visit(j);
			}
		}
		
		int count=0;
		for(int j=0; j<N; j++) {
			if(isHead[j]) {
				count++;
			}
		}
		
		out.println(count);
		out.close();
		in.close();
	}
	
	//recursively visit nodes
	public static void visit(int curr) {
		visited[curr] = true;
		
		int n = nextNode[curr];
			
		if(!visited[n]) {
			isHead[n] = false;
			visit(n);
		}
		else {
			if(n!=currentHead)
				isHead[n] = false;
			isHead[nextNode[n]] = false;
			//This is necessary in a case like this: 1 3 6 10    100 110
		}
	}
}
