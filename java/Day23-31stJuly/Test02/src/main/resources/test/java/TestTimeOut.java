import org.junit.Test;

public class TestTimeOut {

    @Test(timeout = 1000)
    public void testWithTimeout() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("Running before Time out");
    }
}
