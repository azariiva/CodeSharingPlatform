import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static class Sum implements BinaryOperator<Long> {

        @Override
        public Long apply(Long aLong, Long aLong2) {
            return aLong + aLong2;
        }

        @Override
        public <V> BiFunction<Long, Long, V> andThen(Function<? super Long, ? extends V> after) {
            return BinaryOperator.super.andThen(after);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var timeStamps = IntStream.range(0, 2)
                .mapToObj((__) -> scanner.nextLine())
                .map(String::trim)
                .map(LocalTime::parse)
                .collect(Collectors.toUnmodifiableList());
        System.out.println(Math.abs(ChronoUnit.SECONDS.between(timeStamps.get(0), timeStamps.get(1))));
    }
}