package functional.chap09.priceprocessor;

import functional.chap09.model.Order;

import java.math.BigDecimal;
import java.util.function.Function;

public class TaxiPriceProcessor implements Function<Order, Order> {

    private final BigDecimal taxRate;

    public TaxiPriceProcessor(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }
    @Override
    public Order apply(Order order) {
        return order.setAmout(order.getAmout().multiply(taxRate.divide(new BigDecimal(100)).add(BigDecimal.ONE)));
    }
}
