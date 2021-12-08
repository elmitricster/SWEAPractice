import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3499_perfectShuffle {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] front;
			if(N%2 == 1) {
				front = new String[N/2 + 1];
			} else {
				front = new String[N/2];
			}
			String[] back = new String[N/2];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < front.length; i++) {
				front[i] = st.nextToken();
			}
			for (int i = 0; i < back.length; i++) {
				back[i] = st.nextToken();
			}
			
			System.out.print("#" + t + " ");
			for (int i = 0; i < back.length; i++) {
				System.out.print(front[i] + " ");
				System.out.print(back[i] + " ");
			}
			
			if(N%2 == 1) {
				System.out.print(front[N/2]);
			}
			System.out.println();
		}
	}
}
