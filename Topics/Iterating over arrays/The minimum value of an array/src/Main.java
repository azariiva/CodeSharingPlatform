import java.util.Scanner;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        Stream<Integer> arrStream = Stream.of(scanner.nextLine().split("\\s"))
                .map(Integer::parseInt)
                .limit(size);
        System.out.println(arrStream.min(Integer::compare).get());
    }
}