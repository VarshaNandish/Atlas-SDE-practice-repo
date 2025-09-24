package com.example;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;

public class BeanMatcherDemo {

    @Test
    public void check() {
        Customer customer = new Customer("John", "Abraham");
        assertThat(customer, hasProperty("fname"));
    }
}
