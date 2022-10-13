// do not remove imports
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Function;

class ArrayUtils {
    public static <T> String info(T[] arr) {
        var string = new StringBuilder();
        string.append("[");
        if (arr.length != 0) {
            for (int i = 0; i < arr.length - 1; i++) {
                string.append(arr[i].toString());
                string.append(", ");
            }
            string.append(arr[arr.length - 1]);
        }
        string.append("]");
        return string.toString();
    }
}