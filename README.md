# Balanced Brackets

A small Java console program that checks whether the brackets in a string are balanced, using a stack.

## The problem

Given a string, decide whether its brackets `()`, `[]` and `{}` are balanced. A string is balanced if:

1. Every opening bracket has a matching closing bracket of the same type.
2. Brackets close in the correct order (the most recently opened one must close first).

Characters that are not brackets are ignored, so code-like strings such as `"if (a[i] > 0) { x = 1; }"` work too.

## How it works

The program walks through the string one character at a time:

- **Opening bracket** (`(`, `[`, `{`): push it onto the stack.
- **Closing bracket** (`)`, `]`, `}`):
  - If the stack is empty, there is nothing to match it with, so return `false`.
  - Otherwise pop the top of the stack. If it is not the matching opening bracket, return `false`.
- **Any other character**: ignore it.

After the last character, the string is balanced only if the stack is empty. A non-empty stack means some brackets were never closed.

The stack holds the brackets that are still open, with the most recent one on top, which is exactly the one that has to be closed next.

## Examples

| Input | Output | Why |
|---|---|---|
| `"()"` | `true` | Simple match |
| `"([]{})"` | `true` | Properly nested |
| `"(]"` | `false` | Wrong closing type |
| `"([)]"` | `false` | Closed in the wrong order |
| `"((("` | `false` | Never closed |
| `")"` | `false` | Closing bracket with nothing open |
| `""` | `true` | No brackets, nothing unmatched |
| `"if (a[i] > 0) { x = 1; }"` | `true` | Other characters are ignored |
| `"if (a[i > 0) { }"` | `false` | `[` is never closed |

## Running it

1. Create a Java project and add `BalancedBrackets.java` to the `src` folder.
2. Run the file as a Java Application (in Eclipse: right-click the file, then **Run As > Java Application**).
3. The `main` method prints the result for each example above.

Or from a terminal:

```
javac BalancedBrackets.java
java BalancedBrackets
```

## What I learned

- How a stack (last in, first out) fits problems where the most recent thing must be handled first.
- Reading a compile error and tracing it back to the line that caused it, especially mismatched braces.
- Checking what a loop does when it runs zero times (the empty string).
- Why `return` statements need to sit after the loop, not inside it.

## Possible next steps

- Return the index of the first problem bracket instead of `true`/`false`.
- Use `ArrayDeque` instead of the older `Stack` class.
