import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3234_balances {
	static int[] arr;
	static int T, N, answer;
	static int sum, mid;
	static int[] result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		result = new int[10];
		result[0] = 1;
		for (int i = 1; i < 10; i++) {
			result[i] = result[i-1] * i * 2;
		}
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			sum = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}
			
			if(sum % 2 == 0)
				mid = sum / 2;
			else
				mid = sum / 2 + sum % 2;
			
			answer = 0;
			
			dfs(new boolean[N], 0, 0, 0);
			System.out.println("#" + tc + " " + answer);
		}
	}

	public static void dfs(boolean[] b, int k, int left, int right) {
		if (left < right) {
			return;
		}
		
		if (left >= mid) {
			answer += result[N-k]; 
			return;
		}
		
		for (int i = 0; i < arr.length; i++) { // 순열 안에서 부분 집합 돌리기
			if(b[i])
				continue;
			
			int weight = arr[i];
			b[i] = true;
			dfs(b, k+1, left+weight, right);
			b[i] = false;
			
			// 가지치기
			if(right+weight <= left) {
				b[i] = true;
				dfs(b, k+1, left, right+weight);
				b[i] = false;
			}
		}
	}
	
}
