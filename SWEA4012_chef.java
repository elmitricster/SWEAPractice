import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA4012_chef {
	static int[][] ingredient;
	static int N, min;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			ingredient = new int[N][N];
			visited = new boolean[N];
			min = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					ingredient[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("#").append(tc).append(" ");
			combination(0, 0);
			sb.append(min).append("\n");
			
		}
		System.out.println(sb.toString());
	}
	
	public static void combination(int cnt, int idx) {
		if (cnt == N/2) {
			synergy();
			return;
		}
		
		for (int i = idx; i < N; i++) {
			visited[i] = true;
			combination(cnt+1, i+1);
			visited[i] = false;
		}
	}
	
	public static void synergy() {
		int A = 0, B = 0;
		int res = 0;
		
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				if(visited[i] && visited[j]) {
					A += ingredient[i][j] + ingredient[j][i];
				} else if(!visited[i] && !visited[j]) {
					B += ingredient[i][j] + ingredient[j][i];
				}
			}
		}
		
		res = Math.abs(A-B);
		min = Math.min(res, min);
	}

}
