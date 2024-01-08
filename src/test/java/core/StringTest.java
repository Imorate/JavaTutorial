package core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("String test")
public class StringTest {
    @DisplayName("Strings inside StringPool are the same object")
    @Test
    void shouldBeTheSameString() {
        String str1 = "Hello";
        String str2 = "Hello";

        assertEquals(str1, str2);
        assertSame(str1, str2);
    }

    @DisplayName("Strings inside StringPool and outside are not the same object")
    @Test
    @SuppressWarnings("StringOperationCanBeSimplified")
    void shouldNotBeTheSameString() {
        String str1 = "Hello";
        String str2 = new String("Hello");

        assertNotSame(str1, str2);
        assertEquals(str1, str2);
    }

    @DisplayName("Strings are immutable")
    @Test
    void shouldStringsImmutable() {
        String str1 = "Hello";
        String str2 = str1.toLowerCase();

        assertNotSame(str1, str2);
    }
}
