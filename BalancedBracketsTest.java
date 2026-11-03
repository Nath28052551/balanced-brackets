import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BalancedBracketsTest {

    @Test
    void simplePairIsBalanced() {
        assertTrue(BalancedBrackets.isBalanced("()"));
    }

    @Test
    void mixedBracketsAreBalanced() {
        assertTrue(BalancedBrackets.isBalanced("([]{})"));
    }

    @Test
    void emptyStringIsBalanced() {
        assertTrue(BalancedBrackets.isBalanced(""));
    }

    @Test
    void mismatchedPairIsNotBalanced() {
        assertFalse(BalancedBrackets.isBalanced("(]"));
    }

    @Test
    void wrongOrderIsNotBalanced() {
        assertFalse(BalancedBrackets.isBalanced("([)]"));
    }

    @Test
    void onlyOpeningBracketsIsNotBalanced() {
        assertFalse(BalancedBrackets.isBalanced("((("));
    }

    @Test
    void closingBracketFirstIsNotBalanced() {
        assertFalse(BalancedBrackets.isBalanced(")"));
    }

    @Test
    void ignoresNonBracketCharacters() {
        assertTrue(BalancedBrackets.isBalanced("if (a[i] > 0) { x = 1; }"));
    }

    @Test
    void ignoresCharactersButStillDetectsErrors() {
        assertFalse(BalancedBrackets.isBalanced("if (a[i > 0) { }"));
    }
    @Test
    void balancedReturnsMinusOne() {
        assertEquals(-1, BalancedBrackets.firstMismatchIndex("([]{})"));
    }

    @Test
    void emptyStringReturnsMinusOne() {
        assertEquals(-1, BalancedBrackets.firstMismatchIndex(""));
    }

    @Test
    void closingBracketFirstIsIndexZero() {
        assertEquals(0, BalancedBrackets.firstMismatchIndex(")"));
    }

    @Test
    void wrongClosingBracketIsReported() {
        assertEquals(1, BalancedBrackets.firstMismatchIndex("(]"));
    }

    @Test
    void ignoresOtherCharactersWhenCountingIndex() {
        assertEquals(3, BalancedBrackets.firstMismatchIndex("a(b]"));
    }

    @Test
    void unclosedOpeningBracketIsReported() {
        assertEquals(0, BalancedBrackets.firstMismatchIndex("((("));
    }

    @Test
    void firstUnclosedOpeningBracketInTheMiddle() {
        assertEquals(1, BalancedBrackets.firstMismatchIndex("a(b"));
    }
}