import java.util.function.UnaryOperator;

class PrefixSuffixOperator {

    public static final String PREFIX = "__pref__";
    public static final String SUFFIX = "__suff__";

    public static UnaryOperator<String> operator = s -> new StringBuilder(s.trim())
            .insert(0, PREFIX)
            .append(SUFFIX)
            .toString();
}