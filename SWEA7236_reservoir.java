import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA7236_reservoir {
	static int[] dx = {-1, 0, 1, 0, 1, 1, -1, -1};
	static int[] dy = {0, -1, 0, 1, -1, 1, 1, -1};
	static int T, N, cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			char[][] map = new char[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}
			
			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cnt = 0;
					if (map[i][j] == 'W') {
						solve(map, i, j);
					}
					if(max < cnt) {
						max = cnt;
					}
				}
			}
			
			if (max <= 0) {
				System.out.println("#" + tc + " " + 1);
			} else {
				System.out.println("#" + tc + " " + max);
			}
		}
	}
	
	public static void solve(char[][] map, int x, int y) {
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >=0 && ny >= 0 && nx < N && ny < N) {
				if (map[nx][ny] == 'W') {
					cnt++;
				}
			}
		}
	}

}
