

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA5432_ironCut {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine()); // 한줄 읽어옴 문자열로
		
		long startTime = System.currentTimeMillis();
		
		for (int testCase = 1; testCase <= TC; testCase++) {
			String s = br.readLine(); // 문자열 ()()()))))
			int cnt = 0; // 현재 바닥에 놓여있는 쇠막대기의 개수
			int sum = 0; // 레이저로 쪼개지는 쇠막대기의 총 개수
			
			s = s.replace("()", "v"); // 레이저 두글자() 표시를 한글자 표시로 변경
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == 'v') { // 레이저라면, sum 에 cnt 만큼 누적
					sum += cnt;
				} else if (s.charAt(i) == '(') { // 시작괄호, cnt++
					cnt++;
				} else { // 닫는괄호, sum에 쪼가리 1개 추가, cnt--
					sum++;
					cnt--;
				}
			}
			System.out.println("#"+testCase+" "+sum);
		} // end of for testCase
		
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	} // end of main
} // end of class




















