/*
 * Walking robot
 */
import java.util.*;
public class robot {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(); //# of commands
		int M = in.nextInt(); //# of obstacles
		
		int[] commands = new int[N];
		for(int j=0; j<N; j++)
			commands[j] = in.nextInt();
		
		boolean[][] isObstacle = new boolean[2001][2001];
        for(int i=0; i<M; i++) {
        	int x = in.nextInt()+1000;
        	int y = in.nextInt()+1000;
        	isObstacle[x][y] = true;
        }
        
        long maxD2 = 0;
        int cx = 1000;
        int cy = 1000;
        int dir = 0;  //north(0); west(1); south(2); east(3)
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};

        for(int j=0; j<N; j++) {
            if(commands[j]==-2) //turn left
                dir = (dir+1)%4;
            else if(commands[j]==-1) //turn right
                dir = (dir+3)%4;
            else { //move commands[j] steps
                for(int u=0; u<commands[j]; u++) {
                    int nx = cx + dx[dir];
                    int ny = cy + dy[dir];
                    if(nx>=0 && nx<=2000 && ny>=0 && ny<=2000 && 
                    		isObstacle[nx][ny])
                        break;
                    cx = nx;
                    cy = ny;
                    long d2 = (cx-1000L)*(cx-1000) + (cy-1000L)*(cy-1000);
                    maxD2 = Math.max(maxD2, d2);
                }
            }            
        }
        System.out.println(maxD2);
        in.close();
    }
}