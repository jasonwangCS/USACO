/*
 * Breed flip (Feb 2020)
 */
import java.util.*;
import java.io.*;
public class breedflip2 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("breedflip.in"));
		PrintWriter out = new PrintWriter(new File("breedflip.out"));

		int N = in.nextInt();  //length of the two Strings
		String s1 = 'G' + in.next(); //String1
		String s2 = 'G' + in.next(); //String2
		
		//A clump must come after a position x where s1[x] != s2[x] but
		//  s1[x-1] == s2[x-1]. A letter 'G' has been inserted at the
		//  beginning of s1 and s2.
		
		int count = 0;   //# of flips needed
		for(int x=1; x<=N; x++) {
			if(s1.charAt(x-1)==s2.charAt(x-1) && s1.charAt(x)!=s2.charAt(x))
				count++;
		}
		
		out.println(count);
		in.close();
		out.close();
	}
}
