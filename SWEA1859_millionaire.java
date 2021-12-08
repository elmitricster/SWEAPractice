import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1859_millionaire {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = arr[N-1];
			long sum = 0;
			
			for (int i = N-2; i >= 0; i--) {
				if (max > arr[i])
					sum += max - arr[i];
				else
					max = arr[i];
			}
			
			System.out.println("#" + tc + " " + sum);
		}
	}

}
