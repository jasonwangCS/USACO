/*
 * Contaminated milk (Dec 2015)
 */
import java.io.*;
import java.util.Scanner;
public class badmilk {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("badmilk.in"));
		PrintWriter out = new PrintWriter(new File("badmilk.out"));
		
		int N = in.nextInt();  //# of people
		int M = in.nextInt();  //# of milk
		int D = in.nextInt();  //# of drinking records
		int S = in.nextInt();  //# of sick records

		//drink[p][m][t]: person p drank milk m at time t
		boolean[][][] drink = new boolean[N+1][M+1][101]; 
		for(int x=0; x<D; x++) {
			int p = in.nextInt(); //person
			int m = in.nextInt(); //milk
			int t = in.nextInt(); //time
			drink[p][m][t] =  true;
		}

		//sick[j][0]: sick person p
		//sick[j][1]: sick time t
		//  person p got sick at time t
		int[][] sick = new int[S][2];
		for(int j=0; j<S; j++) {
			sick[j][0] = in.nextInt(); //person
			sick[j][1] = in.nextInt(); //time
		}

		//initially all milk is considered good
		boolean[] isMilkBad = new boolean[M+1]; 

		for(int j=0; j<S; j++) { //for each sick record
			//check all milk a sick person drank before sick time
			int p = sick[j][0];
			int t = sick[j][1];
			for(int m=1; m<=M; m++) {
				for(int t2=1; t2<t; t2++) {
					if(drink[p][m][t2])
						isMilkBad[m] = true; //could be bad; 
				}       //unless proven otherwise in the loop below
			}
		}
		
		for(int j=0; j<S; j++) { //for each sick record
			//if a sick person drank a milk after (not before) sick time, 
			//  then the milk is NOT bad.
			int p = sick[j][0];
			int t = sick[j][1];
			for(int m=1; m<=M; m++) {
				boolean milkTasted = false;
				for(int t2=1; t2<t; t2++) {
					if(drink[p][m][t2]) {
						milkTasted = true;
						break;
					}
				}
				if(!milkTasted)
					isMilkBad[m] = false;
			}
		}

		//for each possible bad milk, count the number of person tasted it
		int maxSick = 0;
		for(int m=1; m<=M; m++) {
			if(isMilkBad[m]) {
				int sum = 0;
				for(int p=1; p<=N; p++) {
					boolean personHadMilk = false;
					for(int t=1; t<=100; t++)
						personHadMilk = personHadMilk || drink[p][m][t];

					sum += personHadMilk ? 1 : 0;
				}
					
				maxSick = Math.max(maxSick, sum);
			}
		}
		
		out.println(maxSick);
		out.close();
		in.close();
	}
}
