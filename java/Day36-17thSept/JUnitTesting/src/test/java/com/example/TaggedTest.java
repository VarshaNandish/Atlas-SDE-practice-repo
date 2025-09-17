package com.example;

import com.example.tags.Fast;
import com.example.tags.Slow;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaggedTest {

    @Test
    @Fast
    void quickUnitTest() {
        int result = 2 + 2;
        assertEquals(4, result);
        System.out.println("Running FAST test");
    }

    @Test
    @Slow
    void longRunningTest() throws InterruptedException {
        Thread.sleep(2000); // simulate long task
        assertEquals(9, 3 * 3);
        System.out.println("Running SLOW test");
    }
}
