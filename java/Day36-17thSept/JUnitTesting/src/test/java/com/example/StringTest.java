package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringTest {

    @Test
    void testStringEquality() {
        assertEquals("Hello", "Hello");
    }

    @Test
    void testStringLength() {
        assertEquals(5, "Hello".length());
    }
}
