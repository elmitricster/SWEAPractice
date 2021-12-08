import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA2805_farm {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int total = 0;
			int N = Integer.parseInt(br.readLine());
			int[][] farm = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					farm[i][j] = s.charAt(j) - 48;
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = Math.abs(N/2-i); j <= 2*(N/2)-Math.abs(N/2-i); j++) {
					total += farm[i][j];
				}
			}
			
			System.out.println("#" + tc + " " + total);
		}

	}

}
