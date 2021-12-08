import java.util.Scanner;

public class SWEA1210_ladder1 {

	public static int ladder[][] = new int[100][100];
	public static boolean check = false;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 0; t <= 10 ; t++) {
			int t_cnt = sc.nextInt();
			int result = 0;
			check = false;
			
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					ladder[r][c] = sc.nextInt();
				}
			}
			
			for (int c = 0; c < 100; c++) {
				if(ladder[0][c] == 1) {
					findR(0, c);
					
					if (check) {
						result = c;
						break;
					}
				}
			}
			
			System.out.println("#" + t_cnt + " " + result);
		}
	}
	
	public static void findR(int i, int j) {
		boolean visited[][] = new boolean[100][100];
		
		while (i < 100) {
			visited[i][j] = true;
			
			if (ladder[i][j] == 2) {
				check = true;
				break;
			}
			
			if(j-1>=0 && ladder[i][j-1] == 1 && visited[i][j-1] == false) {
				j--;
			} else if(j+1<100 && ladder[i][j+1] == 1 && visited[i][j+1] == false) {
				j++;
			} else {
				i++;
			}
			
		}
	
	}

}