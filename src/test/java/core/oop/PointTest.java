package core.oop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Point class test")
class PointTest {
    @Test
    @DisplayName("The second point object should be referenced to the first point object")
    void secondPointShouldBeReferencedToFirstPoint() {
        Point p1 = new Point();
        p1.setX(10);
        p1.setY(20);

        @SuppressWarnings("UnnecessaryLocalVariable")
        // Set p2 reference to the p1
        Point p2 = p1;
        p2.setX(0);

        assertEquals(0, p1.getX());
        assertEquals(20, p1.getY());
    }

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