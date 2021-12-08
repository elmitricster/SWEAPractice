import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA1228_password1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			LinkedList<String> list = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < N; i++) {
				list.offer(st.nextToken());
			}
			
			int order = Integer.parseInt(br.readLine());
			int cnt = 0;

			st = new StringTokenizer(br.readLine(), " ");
		
			while (cnt < order) {
				st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				for (int i = 0; i < y; i++) {
					list.add(x+i, st.nextToken());
				}
				cnt++;
			}
			
			System.out.print("#" + tc + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(list.poll() + " ");
			}
			System.out.println();

		}

	}

}
