import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final String dateTimeFormatString = "yyyy-MM-dd'T'HH:mm[:ss]";
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateTimeFormatString);
        final Scanner scanner = new Scanner(System.in);

        final String dateTimeString = scanner.nextLine().trim();
        final LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, dateTimeFormatter);
        final LocalDate date = dateTime.plusHours(11).toLocalDate();
        System.out.println(date);
    }
}