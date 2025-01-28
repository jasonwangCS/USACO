/*
 * Longest palindrome
 */
import java.util.*;
public class palindrome {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		
        int[] freq = new int[52]; //frequency of all letters
        for(int j=0; j<s.length(); j++) {
            char ch = s.charAt(j);
            if(ch<='Z') //upper case letters
                freq[ch-'A']++;
            else //lower case letters
                freq[ch-'a'+26]++;
        }
        
        int ans = 0;
        boolean hasOdd = false;
        for(int k=0; k<52; k++) {
            if(freq[k]%2==0)
                ans+=freq[k];
            else {
                hasOdd = true;
                ans += freq[k]-1;
            }
        }
        
        if(hasOdd) ans++; //put one letter with odd frequency in the middle
        System.out.println(ans);
		in.close();
	}
}