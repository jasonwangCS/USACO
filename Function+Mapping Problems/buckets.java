/*
 * Buckets (Mar 2019)
 */
import java.util.*;
import java.io.*;
public class buckets {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("buckets.in"));
		PrintWriter out = new PrintWriter(new File("buckets.out"));

		int r1=0, c1=0;  //index of barn
		int r2=0, c2=0;  //index of rock
		int r3=0, c3=0;  //index of lake
		
		for(int r=0; r<10; r++) {
			String line = in.next();
			
			for(int c=0; c<10; c++) {
				if(line.charAt(c)=='B') {
					r1 = r;
					c1 = c;
				}
				else if(line.charAt(c)=='R') {
					r2 = r;
					c2 = c;
				}
				else if(line.charAt(c)=='L') {
					r3 = r;
					c3 = c;
				}
			}
		}
		
		int dist = Math.abs(r1-r3) + Math.abs(c1-c3) - 1;

		if(r1==r2 && r1==r3 && (c1-c2)*(c2-c3)>0)
			dist += 2;
		else if(c1==c2 && c1==c3 && (r1-r2)*(r2-r3)>0)
			dist += 2;
		
		out.println(dist);
		out.close();
		in.close();
	}
}
