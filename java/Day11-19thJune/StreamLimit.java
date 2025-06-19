import java.util.stream.Stream;
public class StreamLimit{
    public static void main(String[] args) {
        Stream<Integer> nums = Stream
                .iterate(1, n -> n + 1)
                .limit(20);
        //nums.limit(20)
           //     .forEach(System.out::println);
        nums.limit(10)
                .forEach(System.out::println);
    }
}
