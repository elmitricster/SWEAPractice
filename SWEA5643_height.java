import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA5643_height {
	static int N, M, T;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
     
            // 문제에서 주어진대로 입력을 받음.
            boolean[][] arr = new boolean[N + 1][N + 1];
     
            // 문제에서 주어진 것과 반대로 입력을 받음.
            boolean[][] reverse_arr = new boolean[N + 1][N + 1];
     
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
     
                arr[a][b] = true;
                reverse_arr[b][a] = true;
            }
     
            // 플로이드 와샬 알고리즘 수행
            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        if (arr[i][k] && arr[k][j]) {
                            arr[i][j] = true;
                        }
                    }
                }
            }
     
            // 플로이드 와샬 알고리즘 수행
            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        if (reverse_arr[i][k] && reverse_arr[k][j]) {
                            reverse_arr[i][j] = true;
                        }
                    }
                }
            }
     
            // 특정 학생에 대하여 키가 큰 사람과 작은 학생 모두를 파악 가능.
            // 만약 |을 취한 값이 false라면, 그 학생과 키 비교를 할 수 없다는 의미.
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    arr[i][j] |= reverse_arr[i][j];
                }
            }
     
            int ans = 0;
            outer: for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j) { // 자기 자신은 제외.
                        continue;
                    }
     
                    // 키 비교를 할 수 없는 학생이 존재한다면 continue.
                    if (!arr[i][j]) {
                        continue outer;
                    }
                }
                ans++;
            }
     
            System.out.println("#" + t + " " + ans);
            
        }
      
    }
        
}


/*
public class SWEA5643_height {
	static int N, M, Tcnt, Lcnt;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			arr = new int[N + 1][N + 1];

			for (int m = 0; m < M; m++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				arr[i][j] = 1;
			}

			int result = 0;
			for (int k = 1; k <= N; k++) {
				Tcnt = 0;
				Lcnt = 0;
				tbfs(k, new boolean[N + 1]);
				lbfs(k, new boolean[N + 1]);
				if (Tcnt + Lcnt == N - 1)
					result++;
			}
			System.out.println("#" + tc + " " + result);
		}
	}

	private static void tbfs(int start, boolean[] visited) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int k = q.poll();
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && arr[k][i] == 1) {
					q.offer(i);
					visited[i] = true;
					Tcnt++;
				}
			}
		}
	}

	private static void lbfs(int start, boolean[] visited) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int k = q.poll();
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && arr[i][k] == 1) {
					q.offer(i);
					visited[i] = true;
					Lcnt++;
				}
			}
		}
	}

}
*/


/*
public class SWEA5643_height {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] minEdge;
	static int N, M;
	static int INF = 501;

	public static void main(String[] args) throws Exception {
		int answer = 0;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		minEdge = new int[N][N];
		for (int i = 0; i < N; i++)
			Arrays.fill(minEdge[i], INF);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
            // 
			minEdge[from][to] = 1;
		}

		for (int k = 0; k < N; k++) { // 경유지
			for (int i = 0; i < N; i++) { // 출발지
				for (int j = 0; j < N; j++) { // 도착지
					if (k == i || i == j || k == j)
						continue;
					minEdge[i][j] = Math.min(minEdge[i][j], minEdge[i][k] + minEdge[k][j]);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			boolean flag = true;
			for (int j = 0; j < N; j++) {
				if (i == j || minEdge[i][j] != INF || minEdge[j][i] != INF)
					continue;
				flag = false;
				break;

			}
			if (flag)
				answer++;
		}
		System.out.println(answer);
	}
}
*/

