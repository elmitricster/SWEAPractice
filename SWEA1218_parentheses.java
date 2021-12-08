import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA1218_parentheses {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			String s = br.readLine();
			int answer = 0;
			Stack<Character> stk = new Stack<Character>();
			
			for (int i = 0; i < N; i++) {
				char c = s.charAt(i);
				
				if (c == ')' && !stk.isEmpty() && stk.peek() == '(') {
					stk.pop();
				} else if (c == ']' && !stk.isEmpty() && stk.peek() == '[') {
					stk.pop();
				} else if (c == '}' && !stk.isEmpty() && stk.peek() == '{') {
					stk.pop();
				} else if (c == '>' && !stk.isEmpty() && stk.peek() == '<') {
					stk.pop();
				} else {
					stk.push(c);
				}
			}
			
			if (stk.isEmpty()) {
				answer = 1;
			} else {
				answer = 0;
			}
			
			System.out.println("#" + t + " " + answer);

		}
	}
}
