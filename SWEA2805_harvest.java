import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA2805_harvest {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] farm = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					farm[i][j] = s.charAt(j) - '0';
				}
			}
			
			int sum = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = Math.abs(N/2 - i); j < N - Math.abs(N/2 - i); j++) {
					sum += farm[i][j];
				}
			}
			System.out.println("#" + tc + " " + sum);
		}
	}
}
