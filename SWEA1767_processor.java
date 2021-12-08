import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1767_processor {
	
	static class Pair {
		int x, y;
		
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int T, N, size, min;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Pair core[];
	static boolean check[];	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			core = new Pair[12];
			check = new boolean[12];
			size = 0;
			min = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < N - 1; j++) {
					if (map[i][j] == 1) {
						core[size++] = new Pair(i, j);
					}
				}
			}
			
			for (int i = size; i >= 0; i--) {
				combination(0, 0, i);
				if (min < Integer.MAX_VALUE)
					break;
			}
			
			System.out.println("#" + t + " " + min);
		}
	}
	
	public static void combination(int idx, int cnt, int C) {
		if (cnt == C) {
			dfs(0, 0);
			return;
		}
		
		for (int i = idx; i < size; i++) {
			check[i] = true;
			combination(i+1, cnt+1, C);
			check[i] = false;
		}
	}

	public static void dfs(int idx, int cnt) {
		if (idx == size) {
			min = Math.min(min, cnt);  // 배열 끝가지 돌렸으면 이 때의 최소값 갱신
			return;
		}
		
		if (!check[idx]) {  // 부분집합에 포함되는 코어만 다음 단계로 넘어갈 수 있음
			dfs(idx + 1, cnt);
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int x = core[idx].x;
			int y = core[idx].y;
			int tmp = 0;
			boolean link = false;
			
			while(true) {
				x += dx[d];
				y += dy[d];
				
				if (x < 0 || x >= N || y < 0 || y >= N) {  // 끝까지 갔으면 연결
					link = true;
					break;
				}
				
				if (map[x][y] != 0)  // 전선이나 코어를 만나면 실패
					break;
				map[x][y] = 2;  // 전선 표시
				tmp++;  // 전선 길이 합
			}
			
			if (link)
				dfs(idx + 1, cnt + tmp);
			
			while(true) {  // 원래 맵으로 돌리기
				x -= dx[d];
				y -= dy[d];
				
				if (x == core[idx].x && y == core[idx].y)
					break;
				map[x][y] = 0;
			}
		}
	}
	
}
