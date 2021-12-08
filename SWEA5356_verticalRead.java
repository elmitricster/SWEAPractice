import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA5356_verticalRead {
	static int T;
	static char[][] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			arr = new char[5][15];
			for (int i = 0; i < 5; i++) {
				Arrays.fill(arr[i], ' ');
			}
			for (int i = 0; i < 5; i++) {
				String s = br.readLine();
				int len = s.length();
				for (int j = 0; j < len; j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			
			sb.append("#").append(tc).append(" ");
			
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 5; j++) {
					if(arr[j][i] != ' ') {
						sb.append(arr[j][i]);
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
