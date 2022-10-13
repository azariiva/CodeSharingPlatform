import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int aSize = Integer.parseInt(scanner.nextLine());
        var arrStream = Arrays.stream(scanner.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .limit(aSize);
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(arrStream.filter(e -> e > n).sum());
    }
}