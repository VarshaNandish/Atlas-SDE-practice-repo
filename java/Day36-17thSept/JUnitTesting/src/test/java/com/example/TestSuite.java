package com.example;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        StringTest.class,
        MathTest.class
})
public class TestSuite {
    // This class remains empty
    // It is only used as a holder for the above annotations
}

