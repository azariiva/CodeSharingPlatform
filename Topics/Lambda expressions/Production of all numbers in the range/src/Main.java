import java.util.function.*;
import java.util.stream.LongStream;


class Operator {
    public static LongBinaryOperator binaryOperator = (left, right) ->
            LongStream.rangeClosed(left, right)
                    .reduce((result, element) -> result * element)
                    .orElse(0);
}