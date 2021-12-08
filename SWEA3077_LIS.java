import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA3077_LIS {
	
	static int t;
	static int n;
	static int[] arr;
	static int[] len;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		t=Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			n=Integer.parseInt(br.readLine());
			arr=new int[n];
			len=new int[n];
			Arrays.fill(len, 1);
			st=new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			int max=-1;
			for (int i = 1; i < n; i++) {
				for (int j = 0; j <i; j++) {
					if(arr[j]<arr[i] && len[i]<len[j]+1) {
						len[i]=len[j]+1;
					}
				}
				if(max<len[i])max=len[i];
			}
			
			System.out.printf("#%d %d\n",tc+1,max);
		}
		
	}
}
