/*
 * Counting liars (Mar 2022)
 */
import java.util.*;
public class liars {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //# of cows
        int[][] cows = new int[n][2];
        for(int j=0; j<n; j++) {
            char dir = in.next().charAt(0);
            cows[j][0] = (dir=='L' ? 0 : 1);
            cows[j][1] = in.nextInt();
        }

        int answer = n-1;  //min # of cows telling lies
        for(int j=0; j<n; j++) { 
        	int h = cows[j][1]; //getting the hiding place of Bessie
            int liars = 0;
            for(int k=0; k<n; k++) {
                if(cows[k][0]==1 && h<cows[k][1] || cows[k][0]==0 && h>cows[k][1]) {
                    liars++;
                }
            }
            answer = Math.min(answer, liars);
        }
        System.out.println(answer);
        in.close();
    }
}