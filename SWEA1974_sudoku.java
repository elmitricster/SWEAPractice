

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1974_sudoku {
	static int sum_Row, sum_Col, sum_Zone;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int[][] arr = new int[9][9];
			ans = 1;
			
			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 9; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < 9; i++) {
				sum_Row = 0;
				sum_Col = 0;
				for (int j = 0; j < 9; j++) {
					sum_Row += arr[i][j];
					sum_Col += arr[j][i];
				}
				
				if(sum_Row != 45 || sum_Col != 45) {
					ans = 0;
				}
			}
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					sum_Zone = 0;
					for (int k = 0; k < 3; k++) {
						for (int l = 0; l < 3; l++) {
							sum_Zone += arr[3*i+k][3*j+l];
						}
					}
					
					if(sum_Zone != 45) {
						ans = 0;
					}
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
		
	}

}
