package com.example;



import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class TestDemoHamcrest {


    @Test
    void method01() {
        User user = new User("john", 52, true);
        assertThat(user, hasProperty("firstName"));
    }


    @Test
    void method2() {
        User user = new User("john", 52, true);


        // Assert that the property "firstName" has the value "Adam"
        assertThat(user, hasProperty("firstName", equalTo("john")));
    }


    @Test
    void method3() {
        User user = new User("john", 52, true);
        assertThat(user, allOf(
                hasProperty("firstName", equalTo("john")),
                hasProperty("age", equalTo(52)),
                hasProperty("premiumUser", equalTo(true))
        ));
    }
    @Test
    void method4() {
        User user = new User("john", 22, true);
        assertThat(user, hasProperty("firstName", not(equalTo("Abraham"))));
    }
}
