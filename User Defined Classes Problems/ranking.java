/*
 * Given a list of distinct integers, display their rankings. 
 */
import java.io.*;
import java.util.*;
public class ranking {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Value[] vals = new Value[n];
		for(int j=0; j<n; j++) {
			vals[j] = new Value(in.nextInt(), j+1);
		}
		in.close();

		//sort vals by increasing integer value
		Arrays.sort(vals, (v1, v2) -> v1.n - v2.n);

		for(int j=0; j<n; j++)
			System.out.print(vals[j].id + " ");
		System.out.println();
	}

	// helper class for an integer value together with the original location
	static class Value {
		int n;
		int id;
		
		Value(int n, int id) {
			this.n = n;
			this.id = id;
		}
	}
}
