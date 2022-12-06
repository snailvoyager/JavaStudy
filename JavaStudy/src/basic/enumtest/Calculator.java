package basic.enumtest;

import java.util.function.BiFunction;

public enum Calculator {
    PLUS("더하기", (a, b) -> (a + b)),
    MINUS("빼기", (a, b) -> (a - b)),
    MULTIPLY("곱하기", (a, b) -> (a * b)),
    DIVIDE("나누기", (a, b) -> (a / b));

    private final String name;
    private final BiFunction<Double, Double, Double> bifunction;

    Calculator(String name, BiFunction<Double, Double, Double> biFunction) {
        this.name = name;
        this.bifunction = biFunction;
    }

    public Double calculate(double a, double b) {
        return this.bifunction.apply(a, b);
    }
}
