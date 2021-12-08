import java.util.Arrays;
import java.util.Scanner;

public class SWEA1208_flatten {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int dump = sc.nextInt();
			int[] arr = new int[100];
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			
			for (int i = 0; i < dump; i++) {
				arr[0]++;
				arr[99]--;
				Arrays.sort(arr);
			}
			System.out.println("#" + tc + " " + (arr[99] - arr[0]));
		}
		
	}

}
