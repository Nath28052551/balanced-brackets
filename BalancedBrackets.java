
import java.util.ArrayDeque;
import java.util.Deque;
public class BalancedBrackets {

	public static boolean isBalanced(String s) {

		Deque<Character> stack = new ArrayDeque<>();

		for (int i = 0; i < s.length(); i++) {
			char s1 = s.charAt(i);
			if (s1 == '(' || s1 == '[' || s1 == '{') {
				stack.push(s1);
			} else if (s1 == ')' || s1 == ']' || s1 == '}') {
				if (stack.isEmpty()) {
					return false;

				}
				char open = stack.pop();
				boolean matches = (open == '(' && s1 == ')') || (open == '[' && s1 == ']')
						|| (open == '{' && s1 == '}');
				if (!matches) {
					return false;

				}

			}
		}
		return stack.isEmpty();

	}

	public static void main(String[] args) {
		System.out.println(isBalanced("()"));
		System.out.println(isBalanced("([]{})"));
		System.out.println(isBalanced("(]"));
		System.out.println(isBalanced("([)]"));
		System.out.println(isBalanced("((("));
		System.out.println(isBalanced(")"));
		System.out.println(isBalanced(""));
		System.out.println(isBalanced("if (a[i] > 0) { x = 1; }"));
		System.out.println(isBalanced("if (a[i > 0) { }"));

	}

}
