import java.util.Scanner;

public class SWEA2001_fly {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int arr[][] = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int sum, max = 0;
			
			for (int i = 0; i < N-M+1; i++) {
				for (int j = 0; j < N-M+1; j++) {
					sum = 0;
					for (int k = 0; k < M; k++) {
						for (int l = 0; l < M; l++) {
							sum += arr[i+k][j+l];
						}
					}
					if (sum > max) {
						max = sum;
					}
				}
			}
			
			System.out.println("#" + t +" "+ max);
			
		}
	}

}
