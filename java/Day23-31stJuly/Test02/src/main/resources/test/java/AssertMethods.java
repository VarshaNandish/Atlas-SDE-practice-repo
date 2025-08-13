import org.junit.Test;
import static org.junit.Assert.*;

public class AssertMethods {

    @Test
    public void testAssertSame() {
        String str = "JUnit";
        String sameRef = str;

        assertSame(str, sameRef);
    }

    @Test
    public void testAssertNotSame() {
        String a = new String("Hello");
        String b = new String("Hello");

        assertNotSame(a, b);
    }

    @Test
    public void testAssertArrayEquals() {
        int[] expected = {1, 2, 3, 4};
        int[] actual = {1, 2, 3, 4};

        assertArrayEquals(expected, actual);
    }
}

