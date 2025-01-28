/*
 * Evolution (Mar 2019)
 */
import java.util.*;
import java.io.*;
public class evolution {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("evolution.in"));
		PrintWriter out = new PrintWriter(new File("evolution.out"));
		
		int N = in.nextInt();  //# of populations

		//save the features of each population
		ArrayList<ArrayList<String>> cows = new ArrayList<ArrayList<String>>();
		for(int j=0; j<N; j++)
			cows.add(new ArrayList<String>());

		for(int j=0; j<N; j++) {
			int K = in.nextInt();  //# of features in population j
			for(int x=0; x<K; x++)
				cows.get(j).add(in.next());
			
			Collections.sort(cows.get(j));
		}

		boolean answer = true;

		outer:
		for(int j=0; j<N; j++) {
			if(cows.get(j).isEmpty()) continue;
			
			for(int k=j+1; k<N; k++) {
				if(cows.get(k).isEmpty()) continue;

				//common features of cows[j] and cows[k]
				ArrayList<String> common = new ArrayList<String>();
				int x=0, y=0;
				while(x<cows.get(j).size() && y<cows.get(k).size()) {
					if(cows.get(j).get(x).compareTo(cows.get(k).get(y))<0)
						x++;
					
					else if(cows.get(j).get(x).compareTo(cows.get(k).get(y))>0)
						y++;

					else {
						common.add(cows.get(j).get(x));
						x++;
						y++;
					}
				}

				//If any population p has any feature that is in cows[j] or cows[k]
				// but not in common, then p must also contain "common".
				for(int p=0; p<N; p++) {
					if(p==j || p==k) continue;
					
					for(String feature : cows.get(p) ) {
						if(!common.contains(feature) &&
							(cows.get(j).contains(feature) || cows.get(k).contains(feature))) {
							if(!cows.get(p).containsAll(common)) {
								answer = false;
								break outer;
							}
						}
					}
				}
			}
		}
	
		if(answer)
			out.println("yes");
		else
			out.println("no");
		out.close();
		in.close();
	}
}
