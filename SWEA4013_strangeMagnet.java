import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA4013_strangeMagnet {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int K = Integer.parseInt(br.readLine());
			int[][] magnet = new int[4][8];
			
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken()) - 1;
				int dir = Integer.parseInt(st.nextToken());
				
				int[] rotate = new int[4];  //회전할 방향을 저장
				rotate[num] = dir;
				
				//오른쪽 자석들 검사
				for (int j = num + 1; j < 4; j++) {
					if (magnet[j-1][2] == magnet[j][6])  //왼쪽 2번톱니(기준)와 오른쪽 6번톱니의 자성이 같으면 회전x
						break;
					else
						rotate[j] = -rotate[j-1];
				}
				
				//왼쪽 자석들 검사
				for (int j = num - 1; j >= 0; j--) {
					if (magnet[j][2] == magnet[j+1][6])  //오른쪽 6번톱니(기준)와 왼쪽 2번톱니의 자성이 같으면 회전x
						break;
					else
						rotate[j] = -rotate[j+1];
				}
				
				//각 자석을 회전
				for (int j = 0; j < 4; j++) {
					if (rotate[j] == 0)  //회전하지 않는 경우
						continue;
					else if (rotate[j] == 1) {  //시계방향 회전
						int tmp = magnet[j][7];
						for (int k = 7; k > 0; k--) {
							magnet[j][k] = magnet[j][k-1];
						}
						magnet[j][0] = tmp;
					} else if (rotate[j] == -1) {  //반시계방향 회전
						int tmp = magnet[j][0];
						for (int k = 0; k < 7; k++) {
							magnet[j][k] = magnet[j][k+1];
						}
						magnet[j][7] = tmp;
					}
				}
			}
			
			int sum = 0;
			for (int i = 0; i < 4; i++) {
				if (magnet[i][0] == 1) {
					sum += Math.pow(2, i);
				}
			}
			
			System.out.println("#" + t + " " + sum);
		}	
	}

}
