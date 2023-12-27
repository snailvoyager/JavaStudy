package basic.enum_singleton;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Supplier;

public enum Calculator {
    ADD(1, AdditionOperation::new),     //ENUM 상수에서 생성되는 객체도 싱글톤
    SUBTRACT(2, SubtractionOperation::new),
    MULTIPLY(3, MultiplicationOperation::new),
    DIVIDE(4, DivisionOperation::new);

    private final int code;
    private final Operation operation;

    Calculator(int code, Supplier<Operation> operationSupplier) {
        this.code = code;
        this.operation = operationSupplier.get();
    }

    public Operation getOperation() {   //ENUM 상수에서 생성된 객체를 얻기
        return this.operation;
    }

    static public Optional<Calculator> getCalculatorByCode(int code) {
        return Arrays.stream(values())
                .filter(x -> x.code == code)
                .findAny();
    }
}
