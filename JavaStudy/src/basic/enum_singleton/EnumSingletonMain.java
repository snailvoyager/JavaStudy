package basic.enum_singleton;

public class EnumSingletonMain {
    public static void main(String[] args) {
        final String rawTemplate = "Json Data...";
        final int code = 1;
        Calculator.getCalculatorByCode(code).ifPresent(x -> x.getOperation().performOperation(rawTemplate));

        final String rawTemplate2 = "Json Data2...";
        final int code2 = 2;
        Calculator.getCalculatorByCode(code2).ifPresent(x -> x.getOperation().performOperation(rawTemplate2));

        final String rawTemplate3 = "Json Data3...";
        Calculator.getCalculatorByCode(code).ifPresent(x -> x.getOperation().performOperation(rawTemplate3));
    }
}
