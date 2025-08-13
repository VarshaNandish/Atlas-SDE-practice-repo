import org.junit.Test;

public class TestException {

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        int a = 10;
        int b = 0;
        int result = a / b;
    }
}
