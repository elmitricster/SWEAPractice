import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5215_hamburger {
	static int N, limit, max;
	static int[][] material;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());
			
			material = new int[N][2];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				material[i][0] = Integer.parseInt(st.nextToken());
				material[i][1] = Integer.parseInt(st.nextToken());
			}
			
			max = select(0,0,0);
			
			System.out.println("#" + tc + " " + max);
			
		}
	}

	public static int select(int cnt, int pre, int cal) {
		if (cal > limit)
			return 0;
		if (cnt == N)
			return pre;
		if (cal >= limit)
			return pre;
		
		int use = select(cnt+1, pre + material[cnt][0], cal + material[cnt][1]);
		int unuse = select(cnt+1, pre, cal);
		
		return Math.max(use, unuse);
	}

}
