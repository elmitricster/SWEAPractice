import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1225_passwordMaker {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10 ; t++) {
			Queue<Integer> q = new LinkedList<>();
			br.readLine().trim();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < 8; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			
			int temp = 0;
			
			top:
			while(true) {
				for (int i = 1; i <= 5; i++) {
					temp = q.poll();
					temp -= i;
					if(temp <= 0) {
						temp = 0;
						q.offer(temp);
						break top;
					}
					q.offer(temp);
				}
			}
			
			System.out.print("#" + t + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}
	}
}
