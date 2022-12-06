package basic.enumtest;

public class CalculatorMain {
    public static void main(String[] args) {
        System.out.println(Calculator.PLUS.calculate(2, 3));
        System.out.println(Calculator.MINUS.calculate(2, 3));
        System.out.println(Calculator.MULTIPLY.calculate(2, 3));
        System.out.println(Calculator.DIVIDE.calculate(5, 2));
    }
}
