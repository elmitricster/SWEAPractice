

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1493_newOperation {
	public static int[][] map = new int[300][300];
	
	static int[] getPosition(int p) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == p) {
					return new int[] {j, i};
				}
			}
		}
		return null;
	}
	
	static int getNum(int x, int y) {
		return map[y][x];
	}
	
	public static void main(String[] args) throws Exception {
		int num = 1; // 배열에 저장할 숫자
		for (int i = 0; i < map.length; i++) { // 시작하는 행의 값, 1열
			for (int j = 0; j < i; j++) {
				int r = i - j;
				int c = j + 1;
				map[r][c] = num++;
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			int [] pPosition = getPosition(p);
			int [] qPosition = getPosition(q);
			int val = getNum(pPosition[0] + qPosition[0], pPosition[1] + qPosition[1]);

			sb.append("#" + tc + " " + val + "\n");
			
		}
		
		System.out.print(sb);

	}
	
}
