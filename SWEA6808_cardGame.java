import java.util.Scanner;

public class SWEA6808_cardGame {
	static int[] cute; // 규영이가 낸 카드
	static int[] yin; // 인영이가 낸 카드
	
	static boolean[] check; // 순열 체크
	static int[] result; // 결과 담는 배열
	
	static int cnt; // 이긴 횟수
	static int all; // 전체 게임 횟수
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		// 9!
		all = 1;
		for (int i = 9; i >= 2; i--) { 
			all *= i;
		}
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			cute = new int[9]; // 규영이가 낸 카드
			yin = new int[9]; // 인영이가 낸 카드
			
			// 규영이가 낸 카드를 true로 저장해서 false는 인영이에게 넣기
			boolean[] card = new boolean[19];
			
			// 규영이가 낸 카드를 true로 하고 저장
			for (int i = 0; i < 9; i++) {
				cute[i] = sc.nextInt();
				card[cute[i]] = true;
			}
			
			int idx = 0;
			
			//인영이가 낸 카드 저장
			for (int i = 1; i <= 18; i++) {
				if(!card[i]) {
					yin[idx++] = i;
				}
			}
			
			result = new int[9];
			check = new boolean[9];
			cnt = 0;
			perm(0);
			
			System.out.println("#" + tc + " " + cnt + " " + (all-cnt));
		}
	}
	
	public static void perm(int index) {
		if(index == 9) {
			int cuteScore = 0; // 규영이 점수
			int yinScore = 0; // 인영이 점수
			
			// 규영이 점수가 크면 규영이 점수에 합 추가
			// 인영이 점수가 크면 인영이 점수에 합 추가
			for (int i = 0; i < 9; i++) {
				if(cute[i] > result[i]) {
					cuteScore += cute[i] + result[i];
				} else {
					yinScore += cute[i] + result[i];
				}	
			}
			
			// 규영이 점수가 크면 cnt 증가
			if(cuteScore > yinScore)
				cnt++;
			
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if(!check[i]) {
				result[index] = yin[i];
				check[i] = true;
				perm(index+1);
				check[i] = false;
			}
		}
	}
	
}
