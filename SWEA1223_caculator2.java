import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA1223_caculator2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			String s = br.readLine(); // 계산식
			String postFix = ""; // 후위식 저장
			Stack<Character> op = new Stack<>(); // op 스택
			Stack<Integer> num = new Stack<>(); // num 스택
			
			// 후위식으로 변환하기
			for (int i = 0; i < N; i++) {
				// 숫자면 후위식에 바로 넣기
				if (s.charAt(i) != '+' && s.charAt(i) != '*') {
					postFix += s.charAt(i);
				} else { // 숫자가 아니면
					if (s.charAt(i) == '*') { // *이면 op 스택에 바로 push
						op.push(s.charAt(i));
					} else { // +이면 자기보다 우선순위가 높은 *를 빼고 push
						do {
							if (op.isEmpty())
								break;
							postFix += op.pop();
						} while (!op.isEmpty() && op.peek() != '+');
						
						op.push(s.charAt(i));
					}
				}
			}
			
			// 나머지 연산자
			while (!op.isEmpty())
				postFix += op.pop();
			
			// 후위식 계산하기
			for (int i = 0; i < postFix.length(); i++) {
				// 숫자면 num 스택에 push
				if (postFix.charAt(i) != '+' && postFix.charAt(i) != '*') {
					num.push(postFix.charAt(i) - '0');
				// 연산자면 2개를 pop해서 계산 후 다시 num 스택에 push
				} else {
					int num1 = num.pop();
					int num2 = num.pop();
					char operator = postFix.charAt(i);
					
					if(operator == '*')
						num.push(num1 * num2);
					else if(operator == '+')
						num.push(num1 + num2);
				}
			}
			
			System.out.println("#" + t + " " + num.peek());		
		}
		
	}

}
