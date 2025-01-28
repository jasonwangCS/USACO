/*
 * Guess the animal (Jan 2019)
 */
import java.util.*;
import java.io.*;
public class guess {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("guess.in"));
		PrintWriter out = new PrintWriter(new File("guess.out"));
				
		int N = in.nextInt();  //# of animals
		String[][] features = new String[N][];
		
		for(int j=0; j<N; j++) {
			in.next();  //animal
			int len = in.nextInt();
			
			features[j] = new String[len];
			for(int x=0; x<len; x++)
				features[j][x] = in.next();

			Arrays.sort(features[j]);
		}
		
		//for each pair of animals, find the maximum # of common features
		int max = 0;
		for(int j=0; j<N; j++) {
			for(int k=j+1; k<N; k++) {
				int count = 0;

				int x=0, y=0;
				while(x<features[j].length && y<features[k].length) {
					int res = features[j][x].compareTo(features[k][y]);
					if(res<0)
						x++;
					else if(res>0)
						y++;
					else {
						x++;
						y++;
						count++;
					}
				}
				max = Math.max(max, count);
			}
		}
		
		out.println(max+1);
		out.close();
		in.close();
	}
}
