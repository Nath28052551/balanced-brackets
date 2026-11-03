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
}