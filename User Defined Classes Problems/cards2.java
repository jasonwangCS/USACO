/*
 * find the probability of picking three cards, where each card shares a 
 * letter or an integer with at least one of the other cards.
 * Each card has a letter and an integer.
 */
import java.util.*;
import java.io.*;
public class cards2 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();   //# of cards

		Card[] cards = new Card[N];
		for(int j=0; j<N; j++) {
			String s = in.next();
			cards[j] = new Card(s.charAt(0), Integer.parseInt(s.substring(1)));
		}
		in.close();
		
		int count = 0;   //# of ways for picking 3 such cards
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				for(int k=j+1; k<N; k++) {
					if((cards[i].share(cards[j]) || cards[i].share(cards[k])) &&
					   (cards[j].share(cards[i]) || cards[j].share(cards[k])) &&
					   (cards[k].share(cards[i]) || cards[k].share(cards[j])))
 						 count++;
				}
			}
		}

		int total = N * (N-1) * (N-2) / 6;  //total # of 3-card combination
		int g = gcf(count, total);
		
		System.out.println(count/g + " " + total/g);
	}

	//helper class Card
	static class Card {
		char letter;
		int num;

		Card(char c, int n) {
			letter = c;
			num = n;
		}

		//if a card shares the letter or the number with "other"
		public boolean share(Card other) {
			return letter==other.letter || num==other.num;
		}
	}

	//find the greatest common factor of two integers
	static int gcf(int a, int b) {
		int r = a%b;
		while(r>0) {
			a = b;
			b = r;
			r = a%b;
		}
		return b;
	}
}
