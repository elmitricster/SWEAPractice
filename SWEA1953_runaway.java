import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1953_runaway {
	static class Point {
		int r, c, time;
		
		Point(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
	
	static int N, M, R, C, L;
	static int[][] map;
	static boolean[][] visited;
	static int answer;
	static int[][] dr = {{0,0,0,0}, {-1,1,0,0}, {-1,1,0,0}, {0,0,0,0}, {-1,0,0,0}, {0,1,0,0}, {0,1,0,0}, {-1,0,0,0}};  //1 - 7번                   
	static int[][] dc = {{0,0,0,0}, {0,0,-1,1}, {0,0,0,0}, {0,0,-1,1}, {0,0,0,1}, {0,0,0,1}, {0,0,-1,0}, {0,0,-1,0}};
	static int[][] dir = {{1,2,5,6}, {1,2,4,7}, {1,3,4,5}, {1,3,6,7}};  //상하좌우
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());  //세로
			M = Integer.parseInt(st.nextToken());  //가로
			R = Integer.parseInt(st.nextToken());  //맨홀 위치 세로
			C = Integer.parseInt(st.nextToken());  //맨홀 위치 가로
			L = Integer.parseInt(st.nextToken());  //지난 시간
			
			map = new int[N][M];
			visited = new boolean[N][M];
			answer = 1;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs(R, C, L);
			
			System.out.println("#" + t + " " + answer);
		}
	}
	
	static void bfs(int y, int x, int l) {
		Queue<Point> q = new LinkedList<>();
		visited[y][x] = true;
		q.add(new Point(y, x, 1));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			if (p.time == L) {
				return;
			}
			
			for (int i = 1; i < 8; i++) {
				if (map[p.r][p.c] == i) {  //파이프 모양 찾기
					for (int j = 0; j < 4; j++) {  //상하좌우
						int nr = p.r + dr[i][j];
						int nc = p.c + dc[i][j];
						
						//지금 위치가 다음 위치와 같은 곳이면 pass
						if (p.r == nr && p.c == nc)
							continue;
						
						//범위 넘어가면 pass
						if (nr < 0 || nc < 0 || nr >= N || nc >= M)
							continue;
						
						// 0이면 못가는 곳
						if (map[nr][nc] == 0)
							continue;
						
						for (int k = 0; k < 4; k++) {  //각 방향마다 갈 수 있는 곳 4군데씩 있음
							if (dir[j][k] == map[nr][nc]) {  //가려고 했을 때 갈 수 있는 곳이면 감
								if (!visited[nr][nc]) {
									visited[nr][nc] = true;
									answer++;
									q.add(new Point(nr, nc, p.time+1));
								}
							}
						}
					}
				}
			}
		}	
	}

}
