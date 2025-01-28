/*
 * Family Tree (Mar 2018)
 */
import java.util.*;
import java.io.*;
public class familytree {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("familytree.in"));
		PrintWriter out = new PrintWriter(new File("familytree.out"));
		
		int N = in.nextInt();   //number of rows to read
		String A = in.next();   //cow A
		String B = in.next();   //cow B
		
		String[][] rel = new String[N][2]; //mother-daughter relation
		for(int j=0; j<N; j++) {
			rel[j][0] = in.next(); //mother
			rel[j][1] = in.next(); //daughter
		}
		
		//all the distinct cows
		ArrayList<String> cows = new ArrayList<String>();
		for(int j=0; j<N; j++) {
			if(!cows.contains(rel[j][0]))
				cows.add(rel[j][0]);
			if(!cows.contains(rel[j][1]))
				cows.add(rel[j][1]);
		}

		int nv = cows.size();  //number of nodes in the family tree
		int[] mother = new int[nv];  //mother[j] is mother of cow j
		Arrays.fill(mother, -1);
		
		for(int j=0; j<N; j++) {
			int id1 = cows.indexOf(rel[j][0]);
			int id2 = cows.indexOf(rel[j][1]);
			mother[id2] = id1;
		}

		//trace cow A's ancestors in the family tree
		ArrayList<String> listA = new ArrayList<String>();
		listA.add(A);
		int from, to;
		from = cows.indexOf(A);
		do {
			to = mother[from];
			if(to>-1) {
				listA.add( cows.get(to) );
				from = to;
			}
		} while (to>-1);
		
		//trace cow B's ancestors in the family tree
		ArrayList<String> listB = new ArrayList<String>();
		listB.add(B);
		from = cows.indexOf(B);
		do {
			to = mother[from];
			if(to>-1) {
				listB.add(cows.get(to));
				from = to;
			}
		} while (to>-1);

		//check the common ancestors of A and B
		boolean isRelated = false;
		for(int y=0; y<listB.size(); y++) {
			int x = listA.indexOf(listB.get(y));

			String anc = A;
			String dec = B;

			if(x>=0) {
				isRelated = true;
				if(x==0 || y==0) {
					if(y==0) { 
						anc = B; dec = A;
					}
					if(x==y)
						out.println(anc + " is " + dec);
					else if(Math.abs(x-y)==1)
						out.println(anc + " is the mother of " + dec);
					else if(Math.abs(x-y)==2)
						out.println(anc + " is the grand-mother of " + dec);
					else {
						out.print(anc + " is the ");
						for(int z=0; z<Math.abs(x-y)-2; z++)
							out.print("great-");
						out.println("grand-mother of " + dec);
					}
				}
				
				else {   //x!=0 && y!=0
					if(x==1 && y==1)
						out.println("SIBLINGS");
					else if(x>1 && y>1)
						out.println("COUSINS");
					else { //x==1 && y>1 || x>1 && y==1
						if(y<x) {
							anc = B; dec = A;
						}

						if(Math.abs(x-y)==1)
							out.println(anc + " is the aunt of " + dec);
						else {
							out.print(anc + " is the ");
							for(int z=0; z<Math.abs(x-y)-1; z++)
								out.print("great-");
							out.println("aunt of " + dec);
						}
					}
				}			
				break;
			}
		}

		if(!isRelated)
			out.println("NOT RELATED");
		
		out.close();
		in.close();
	}
}
