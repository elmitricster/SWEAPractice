import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1233_4fundaVal {
	static final String operator = "+-*/";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int answer = 1;
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int cnt = st.countTokens();
				
				if (cnt == 4) {
					st.nextToken();
					if(!operator.contains(st.nextToken())) {
						answer = 0;
					}
					st.nextToken();
					st.nextToken();
				} else if (cnt == 2) {
					st.nextToken();
					if(operator.contains(st.nextToken())) {
						answer = 0;
					}
				}
			}
			
			System.out.println("#" + tc + " " + answer);
			
		}
		
	}

}
