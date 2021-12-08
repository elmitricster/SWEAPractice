import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA9229_spotMart {
	static int[] snack;
	static int res;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			snack = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
			
			res = -1;
			select(0, 0, 0);
			
			System.out.println("#" + tc + " " + res);
		}
	}
	
	public static void select(int cnt, int idx, int sum) {
		if(sum > M)
			return;
		if(cnt == 2) {
			if(res < sum) 
				res = sum;
			return;
		}
		if(idx == N)
			return;
		
		select(cnt+1 , idx+1, sum+snack[idx]);
		select(cnt, idx+1, sum);
	}
	
}
