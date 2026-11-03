
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
	public static int firstMismatchIndex(String s) {
	    Deque<Integer> stack = new ArrayDeque<>();

	    for (int i = 0; i < s.length(); i++) {
	        char c = s.charAt(i);
	        if (c == '(' || c == '[' || c == '{') {
	            stack.push(i);                       // push the INDEX, not the char
	        } else if (c == ')' || c == ']' || c == '}') {
	            if (stack.isEmpty()) {
	                return i;                      // closing bracket with nothing to match
	            }
	            char open = s.charAt(stack.pop());   // look the opening char up by its index
	            boolean matches = (open == '(' && c == ')') || (open == '[' && c == ']')
	                    || (open == '{' && c == '}');
	            if (!matches) {
	                return i;                      // wrong kind of closing bracket
	            }
	        }
	    }

	    // Loop finished: anything left in the stack was never closed.
	    // Return -1 if the stack is empty, otherwise the earliest unclosed index.
	    if (stack.isEmpty()) {
	        return -1;               // nothing left open, so it's balanced
	    }
	    return stack.peekLast();     // earliest unclosed bracket's index;
	}

}
