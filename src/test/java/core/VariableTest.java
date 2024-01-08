package core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Variable test")
public class VariableTest {
    @Test
    @DisplayName("The second int variable has a different value than the first int variable")
    void secondVariableHasDifferentValueThanFirst() {
        int a = 1;
        int b = a;
        a = 2;

        assertEquals(2, a);
        assertEquals(1, b);
    }
}
