/*
 * Alchemy (Mar 2022)
 */
import java.util.*;
public class alchemy {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); //# of metals
	  	
		int[] have = new int[n]; //available amount for each metal
	  	for(int j=0; j<n; j++) 
	  		have[j] = in.nextInt();
	  	
		int k = in.nextInt(); //# of recipes
	
	  	int[][] need = new int[n][];
	  	while(k-->0) {
	    	int want = in.nextInt();
	    	int m = in.nextInt();

	    	want--;
	    	need[want] = new int[m]; //metal want needs other metals

	    	for(int x=0; x<m; x++)
	    		need[want][x] = in.nextInt()-1;
	  	}
	  	
		int ret = 0; //total amount of metal N-1 that can be obtained
	  	while(true) {
	    	int[] consume = new int[n];
	    	consume[n-1]++;
	    	boolean good = true;
	    	for(int i=n-1; i>=0; i--) {
	    	  	if(consume[i] <= have[i]) {
	        		have[i] -= consume[i];
	        		continue;
	      		}
	      
		  		if(need[i].length == 0) { //can't be produced
	        		good = false;
	        		break;
	      		}
	      		
				int take = have[i]; //have[i] < consume[i]
	      		consume[i] -= take; //can other metals make up enough metal i?
	      		have[i] -= take;
	      		for(int out : need[i]) 
				  	consume[out] += consume[i];
	    	}
	    	
			if(good) 
				ret++;
	    	else 
	    		break;
	  	}
	  	System.out.println(ret);
	  	in.close();
	}
}
