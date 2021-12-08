import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA5644_charging {
	static int T, M, A;
	static int[] moveA, moveB;
	static int[] dx = new int[] {0,0,1,0,-1};
	static int[] dy = new int[] {0,-1,0,1,0}; // 이동x, 상, 우, 하, 좌
	static int Ax, Ay, Bx, By;
	static int[][] BC;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			moveA = new int[M+1];
			moveB = new int[M+1];
			
			StringTokenizer sta = new StringTokenizer(br.readLine(), " ");
			StringTokenizer stb = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= M; i++) {
				moveA[i] = Integer.parseInt(sta.nextToken());
				moveB[i] = Integer.parseInt(stb.nextToken());
			}
			
			BC = new int[A][4];
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				BC[i][0] = Integer.parseInt(st.nextToken());
				BC[i][1] = Integer.parseInt(st.nextToken());
				BC[i][2] = Integer.parseInt(st.nextToken());
				BC[i][3] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(BC, (a,b)->(b[3]-a[3])); // 배터리 성능 내림차순 정렬
			
			Ax = Ay = 1; // A시작점
			Bx = By = 10; // B시작점
			int max = 0;
			
			for (int m = 0; m <= M; m++) {
				Ax += dx[moveA[m]];
				Ay += dy[moveA[m]];
				Bx += dx[moveB[m]];
				By += dy[moveB[m]];
				
				// 중복 확인용
				int AP = -1;
				int BP = -2;
				
				for (int a = 0; a < A; a++) {
					if(BC[a][2] >= (Math.abs(Ax - BC[a][0]) + Math.abs(Ay - BC[a][1]))) {
						AP = a;
						break;
					}
				}
				
				for (int b = 0; b < A; b++) {
					if(BC[b][2] >= (Math.abs(Bx - BC[b][0]) + Math.abs(By - BC[b][1]))) {
						BP = b;
						break;
					}
				}
				
				// 배터리 성능이 가장 큰 곳이 겹쳤다면, 그 다음에 있는 겹치는 큰 부분을 찾음
				if (BP == AP) {
					int a = AP + 1; // 내림차순 정렬이니 AP +1 부터 반복
					for (; a < A; a++) {
						if(BC[a][2] >= Math.abs(Ax - BC[a][0]) + Math.abs(Ay - BC[a][1]) || 
								BC[a][2] >= Math.abs(Bx - BC[a][0]) + Math.abs(By - BC[a][1])) {
							AP = a; // 그 다음으로 큰 배터리 성능을 저장
							break;
						}
					}
					if (a == A) { // 다 돌아도 다른 값이 포함되지 않는다면
						max += BC[AP][3]; // BC[AP][3]에는 하나만 들어가게 됨
					} else { // 다른 충전할 곳이 있다면 그 값을 찾아서 각각 max에 더해줌
						max += BC[AP][3];
						max += BC[BP][3];
					}
				} else { // AP, BP의 값이 서로 다르고, 초기값과도 다르다면 max에 각각 더해줌
					if(AP != -1)
						max += BC[AP][3];
					if(BP != -2)
						max += BC[BP][3];
				}
			}
			
			sb.append('#').append(tc).append(' ').append(max).append('\n');	
		}
		System.out.println(sb);
	}

}
