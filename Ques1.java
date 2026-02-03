// Convert an optional type into Stream
import java.util.*;
import java.util.stream.*;

public class Ques1 {

    public static void main(String[] args) {

        // Example Optional values
        Optional<String> presentOpt = Optional.of("Hello World");
        Optional<String> emptyOpt = Optional.empty();

        System.out.println("=== Java 9+ method ===");
        presentOpt.stream().forEach(System.out::println);
        emptyOpt.stream().forEach(System.out::println);

        // Java 8 compatible method
        System.out.println("\n=== Java 8 method ===");
        optionalToStreamJava8(presentOpt).forEach(System.out::println);
        optionalToStreamJava8(emptyOpt).forEach(System.out::println);

        // Example with List<Optional<T>>
        System.out.println("\n=== List<Optional<T>> to Stream<T> ===");
        List<Optional<Integer>> list = Arrays.asList(
                Optional.of(10),
                Optional.empty(),
                Optional.of(30)
        );

        // Java 9+
        list.stream()
            .flatMap(Optional::stream)
            .forEach(System.out::println);
    }

    // Java 8 helper method to convert Optional to Stream
    public static <T> Stream<T> optionalToStreamJava8(Optional<T> opt) {
        return opt.map(Stream::of)
                  .orElseGet(Stream::empty);
    }
}
