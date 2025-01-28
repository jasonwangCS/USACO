/*
 * mix milk (Dec 2018)
 */
import java.util.*;
import java.io.*;
public class mix {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("mixmilk.in"));
		PrintWriter out = new PrintWriter(new File("mixmilk.out"));
		
		int[] cap = new int[3]; //capacity
		int[] vol = new int[3]; //actual volume
		
		for(int k=0; k<3; k++) {
			cap[k] = in.nextInt();
			vol[k] = in.nextInt();
		}
		
		//run 100 iterations pouring
		for(int k=0; k<100; k++) {
			int k0 = k%3;
			int k1 = (k+1)%3;
			
			//from k0 to k1
			if(vol[k1]+vol[k0] <= cap[k1]) {
				vol[k1] += vol[k0];
				vol[k0] = 0;
			}
			else {
				vol[k0] -= (cap[k1]-vol[k1]);
				vol[k1] = cap[k1];
			}
		}

		for(int j=0; j<3; j++) {
			out.println(vol[j]);
		}
		out.close();
		in.close();
	}
}
