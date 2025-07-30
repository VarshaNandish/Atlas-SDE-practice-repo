import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class JunitTest4 {
    public int compare(int n1, int n2) {
        if (n1 > n2)
            return 1;
        return -1;
    }
    @Test
    public void compare() {
        JunitTest4 obj = new JunitTest4();
        int value = obj.compare(20, 10);
        assertEquals(1, value);
    }
}
