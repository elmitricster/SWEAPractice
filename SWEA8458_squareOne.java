import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA8458_squareOne {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int sum = 0;
			int cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[0] = Math.abs(Integer.parseInt(st.nextToken())) + Math.abs(Integer.parseInt(st.nextToken()));
			int max = arr[0];
			
			for (int i = 1; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i] = Math.abs(Integer.parseInt(st.nextToken())) + Math.abs(Integer.parseInt(st.nextToken()));
				max = Math.max(max, arr[i]);
				if (arr[i] % 2 != arr[i-1] % 2) {
					cnt = -1;
				}
			}
			
			if (cnt==0) {
				while(true) {
					boolean check = true;
					
					if (sum < max || (max-sum)%2 != 0) {
						check = false;
					}
					
					if (check) {
						break;
					}
					
					sum += ++cnt;
				}
			}
			
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
			
		System.out.println(sb);
	}

}
