import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1861_squareRoom {
	public static int[][] sqr;
	public static boolean[][] visited;
	public static int N, start, length;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	
	public static void dfs(int x, int y, int cnt, int position) {
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (0 <= nx && nx < N && 0 <= ny && ny < N) {
				if (!visited[nx][ny] && (sqr[nx][ny] == sqr[x][y] + 1)) {
					dfs(nx, ny, cnt+1, position);
				}
			}
		}
		
		if (cnt > length) {
			length = cnt;
			start = position;
		}
		if (cnt == length) {
			start = Math.min(start, position);
		}
		
		visited[x][y] = false;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			sqr = new int[N][N];
			visited = new boolean[N][N];
			start = 0;
			length = 0;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					sqr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(i, j, 1, sqr[i][j]);
				}
			}
			
			System.out.println("#" + t + " " + start + " " + length);
		}
	}
}
