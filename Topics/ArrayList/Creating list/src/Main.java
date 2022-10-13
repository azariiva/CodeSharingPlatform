import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = Stream.of(2, 0, 1, 7).collect(Collectors.toList());
        System.out.println(list);
    }
}