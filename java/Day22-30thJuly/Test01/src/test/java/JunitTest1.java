import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JunitTest1 {
    String message = "hello all How are you";

    @Test
    void testMsg() {
        System.out.println("asserting the Test case ");
        assertEquals("hello all How are you", message);
    }
}


