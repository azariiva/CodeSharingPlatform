import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final String dateFormatter = "yyyy-MM-dd";
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormatter);
        final Scanner scanner = new Scanner(System.in);

        final String dateString = scanner.nextLine().trim();
        final LocalDate date = LocalDate.parse(dateString, formatter);

        System.out.println(date.plusWeeks(2).format(formatter));
    }
}