import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class JunitTest2 {

    @Test
    @Tag("firstPriority")
    void testMethod01() {
        System.out.println("Running testMethod01");
    }

    @Test
    @Tag("firstPriority")
    void runTestcase02() {
        System.out.println("Running runTestcase02");
    }

    @Test
    @Tag("fastTag")
    void testMethod03() {
        System.out.println("Running testMethod03");
    }

    @Test
    @Tag("slowTag")
    void runTestcase04() {
        System.out.println("Running runTestcase04");
    }
}
