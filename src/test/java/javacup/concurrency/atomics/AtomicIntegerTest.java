package javacup.concurrency.atomics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Atomic Integer class test")
public class AtomicIntegerTest {

    private AtomicInteger atomicInteger;

    @BeforeEach
    void setUp() {
        atomicInteger = new AtomicInteger(20);
    }

    @Test
    @DisplayName("Setter and getter test")
    void testGetterAndSetter() {
        assertEquals(20, atomicInteger.get());
        atomicInteger.set(12);
        assertEquals(12, atomicInteger.get());
        assertEquals(12, atomicInteger.getAndSet(50));
        assertEquals(50, atomicInteger.get());
    }

    @Test
    @DisplayName("Get and Increment/Decrement test")
    void testGetAndIncDec() {
        assertEquals(20, atomicInteger.getAndIncrement());
        assertEquals(21, atomicInteger.get());

        assertEquals(21, atomicInteger.getAndDecrement());
        assertEquals(20, atomicInteger.get());
    }

    @Test
    @DisplayName("Compare and set test")
    void testCompareAndSet() {
        boolean trueStatus = atomicInteger.compareAndSet(20, 50);
        assertTrue(trueStatus);
        assertEquals(50, atomicInteger.get());

        boolean falseStatus = atomicInteger.compareAndSet(70, 1);
        assertFalse(falseStatus);
        assertEquals(50, atomicInteger.get());
    }

}
