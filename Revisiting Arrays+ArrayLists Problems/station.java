import java.util.*;
public class station {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(); //# of stations
		int[] gas = new int[N];
		for(int j=0; j<N; j++)
			gas[j] = in.nextInt();
		
        int total = 0;
		for(int j=0; j<N; j++) {
			gas[j] -= in.nextInt();
			total += gas[j];
		}

		//find the first index to start and come back clockwise
        int sum = 0;
        int loc = 0;
        for(int j=0; j<N; j++) {
            sum += gas[j];
            if(sum < 0) {
                sum = 0;
                loc = j+1;
            }
        }
        System.out.println(total < 0 ? -1 : loc);

        in.close();
	}
}