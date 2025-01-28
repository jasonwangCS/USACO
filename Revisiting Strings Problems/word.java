/*
 * Word processor (Jan 2020)
 */
import java.io.*;
import java.util.*;
public class word {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("word.in"));
		PrintWriter out = new PrintWriter(new File("word.out"));

		int N = in.nextInt(); //# of all words
		int K = in.nextInt(); //# of letters per line allowed
		
		int numLetters = 0; //# of letters in current line
		for(int j=0; j<N; j++) {
			String word = in.next(); //next word
			
			if(numLetters + word.length() <= K) {
				if(numLetters==0)   //word is the first in this line
					out.print(word);
				else
					out.print(" " + word);

				numLetters += word.length();
				
				if(numLetters==K) {
					numLetters = 0;
					out.println();
				}
			}
			else {   //lineLen + word.length() > K
				out.println();
				out.print(word);
				numLetters = word.length();
			}
		}
		
		out.println();
		in.close();
		out.close();
	}
}
