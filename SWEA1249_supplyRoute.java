import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SWEA1249_supplyRoute {
	static class Point implements Comparable<Point> {
		int r, c, cost;
		
		public Point(int r, int c, int cost) {
			super();
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Point o) {
			int diff = this.cost - o.cost;
			return diff;
		}
	}
	
	static int N;
	static int[][] map, distance;
	static int min;
	static int[] dr = {-1, 1, 0 ,0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			
			map = new int[N][N];
			distance = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String[] s = br.readLine().split("");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			for (int i = 0; i < N; i++) {
				Arrays.fill(distance[i], Integer.MAX_VALUE);
			}
			
			sb.append("#" + tc + " " + dijkstra());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static int dijkstra() {
		distance[0][0] = map[0][0];
		
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		pq.add(new Point(0, 0, map[0][0]));
		
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (distance[nr][nc] > distance[cur.r][cur.c] + map[nr][nc]) {
						distance[nr][nc] = distance[cur.r][cur.c] + map[nr][nc]; 
						pq.add(new Point(nr, nc, distance[nr][nc]));
					}
				}
			}
		}
		return distance[N-1][N-1];
	}
	
}