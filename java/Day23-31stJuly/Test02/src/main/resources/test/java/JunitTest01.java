
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Ignore;

public class JunitTest01 {

    String msg1 = "running JunitTest01";

    @Test
    public void msgTest() {
        System.out.println("we are inside the msgTest1()");
        assertEquals(msg1, "running JunitTest01");
    }
}

