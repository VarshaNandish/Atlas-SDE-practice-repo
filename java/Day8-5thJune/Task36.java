public class Task36 {
    public static void add(int x, float y) {
        System.out.println("int x, float y: x = " + x + ", y = " + y);
    }
    public static void add(float x, int y) {
        System.out.println("float x, int y: x = " + x + ", y = " + y);
    }

    public static void main(String[] args) {
        add(10.50f, 60);
        add(100, 80.80f);
    }
}