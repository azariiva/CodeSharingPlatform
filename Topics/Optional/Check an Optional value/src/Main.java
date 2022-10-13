import java.util.Optional;

class Main {
    public static void main(String[] args) {
        ValueProvider provider = new ValueProvider();
        var optVal = provider.getValue();
        optVal.ifPresent(System.out::println);
    }
}

class ValueProvider {
    private Optional<String> inputOpt; // cache to provide reproducing method invocation

    public Optional<String> getValue() {
        if (inputOpt == null) {
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            String input = scanner.next();
            inputOpt = "null".equals(input) ? Optional.empty() : Optional.of(input);
        }

        return inputOpt;
    }
}