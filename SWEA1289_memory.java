import java.util.Scanner;

public class SWEA1289_memory {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		
		for(int t=1; t<=test; t++) {
			String s = sc.next();
			int a[] = new int[s.length()];
			for(int i=0; i<s.length(); i++) {
				a[i] = s.charAt(i) - '0';
			}
			
			int cnt = a[0];
			
			for(int i=1; i<a.length; i++) {
				if(a[i] != a[i-1]) {
					cnt++;
				}
			}
			
			System.out.println("#" + t + " " + cnt);
		}

	}

}
