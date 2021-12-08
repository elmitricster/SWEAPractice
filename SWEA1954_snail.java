import java.util.Scanner;

public class SWEA1954_snail {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int[][] map = new int[n][n];
			int turn = 1, x = 0, y = -1, num = 0;
			
			while(true) {
				for (int i = 0; i < n; i++) {
					y = y + turn;
					map[x][y] = ++num;
				}
				
				n--;
				
				for (int i = 0; i < n; i++) {
					x = x + turn;
					map[x][y] = ++num;
				}
				
				turn *= - 1;
				
				if(n == 0)
					break;
			}
			
			System.out.println("#" + tc + " ");
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
		
	}

}
