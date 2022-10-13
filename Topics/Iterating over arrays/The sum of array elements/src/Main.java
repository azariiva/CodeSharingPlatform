import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int aSize = Integer.parseInt(scanner.nextLine());
        int aSum = Arrays.stream(scanner.nextLine().split("\\s"))
                .limit(aSize)
                .mapToInt(Integer::parseInt)
                .sum();
        System.out.println(aSum);
    }
}