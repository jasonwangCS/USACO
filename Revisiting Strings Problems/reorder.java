/*
 * Palindrome reorder
 */
import java.io.*;
import java.util.*;
public class reorder {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		in.close();
		
		int[] freq = new int[26];
		for(int x=0; x<str.length(); x++)
			freq[str.charAt(x)-'A']++;

		int odd = 0; //# of letters with odd frequency
		int id = -1; //index of the last letter with odd frequency
		
		ArrayList<Character> list = new ArrayList<>(str.length());
		for(int j=0; j<26; j++) {
			for(int x=0; x<freq[j]/2; x++)
				list.add((char)(j+'A'));

			if(freq[j]%2==1) {
				odd++;
				id = j;
			}
		}
		
		if(odd>=2)
			System.out.println("NO SOLUTION");
		else {
			for(char ch : list)
				System.out.print(ch);

			if(odd==1)
				System.out.print((char)(id+'A'));

			for(int j=list.size()-1; j>=0; j--)
				System.out.print(list.get(j));

			System.out.println();
		}
	}
}
