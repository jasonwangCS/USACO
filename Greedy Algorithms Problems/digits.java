/*
 * Remove digits
 */
import java.util.*;
public class digits {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String num = in.next();
		int K = in.nextInt();
		in.close();

		ArrayList<Character> R = new ArrayList<>(); //remaining
		int removal = 0; //# of removals
		int j = 0;
		int N = num.length();
		while(removal<K && j<N) {
			R.add(num.charAt(j));
			if(j+1<N) {
				while(removal<K && !R.isEmpty() && 
						R.get(R.size()-1)>num.charAt(j+1)) {
					R.remove(R.size()-1);
					removal++;
				}
			}
			
			j++;
		}
		
		//...
		if(j==N && removal<K) {
			for(; removal<K; removal++)
				R.remove(R.size()-1);
		}

		//...
		for(; j<N; j++) 
			R.add(num.charAt(j));

		//...
		int x = 0;
		for(; x<R.size(); x++)
			if(R.get(x)!='0') break;

		//...
		if(x<R.size())
			for(; x<R.size(); x++)
				System.out.print(R.get(x));
		else
			System.out.println("0");
	}
}