import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JunitTest5 {

    public int compare(int n1, int n2) {
        if (n1 > n2)
            return 1;
        else if (n1 < n2)
            return -1;
        return 0;
    }

    @Test
    public void compareTest1() {
        JunitTest5 obj = new JunitTest5();
        int result = obj.compare(10, 5);
        assertEquals(1, result);
    }

    @Test
    public void compareTest2() {
        JunitTest5 obj = new JunitTest5();
        int result = obj.compare(5, 10);
        assertEquals(-1, result);
    }

    @Test
    public void compareTest3() {
        JunitTest5 obj = new JunitTest5();
        int result = obj.compare(7, 7);
        assertEquals(0, result);
    }
}

