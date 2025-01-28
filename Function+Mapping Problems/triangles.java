/*
 * Triangle (Feb 2020)
 */
import java.util.*;
import java.io.*;
public class triangles {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("triangles.in"));
		PrintWriter out = new PrintWriter(new File("triangles.out"));

		int N = in.nextInt();  //# of points
		int[][] pts = new int[N][2];
		for(int j=0; j<N; j++) {
			pts[j][0] = in.nextInt();
			pts[j][1] = in.nextInt();
		}
		
		//check every three points
		int total = 0;
		for(int i=0; i<N; i++) {
			int x1 = pts[i][0];
			int y1 = pts[i][1];

			for(int j=i+1; j<N; j++) {
				int x2 = pts[j][0];
				int y2 = pts[j][1];
				
				for(int k=j+1; k<N; k++) {
					int x3 = pts[k][0];
					int y3 = pts[k][1];
				
					int area = 0;
					
					if(y1==y2 && x1==x3)
						area = (x2-x1)*(y3-y1);
					
					else if(y1==y3 && x1==x2)
						area = (x3-x1)*(y2-y1);

					else if(y2==y1 && x2==x3)
						area = (x1-x2)*(y3-y2);
					
					else if(y2==y3 && x1==x2)
						area = (x3-x2)*(y1-y2);
					
					else if(y3==y1 && x3==x2)
						area = (x1-x3)*(y2-y3);
					
					else if(y3==y2 && x3==x1)
						area = (x2-x3)*(y1-y3);

					if(area<0) area = -area;
					total = Math.max(total, area);
				}
			}
		}
		
		out.println(total);
		in.close();
		out.close();
	}
}
