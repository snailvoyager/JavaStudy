package functional.chap09.priceprocessor;

import functional.chap09.model.OrderLine;
import functional.chap09.model.Order;

import java.math.BigDecimal;
import java.util.function.Function;

public class OrderLineAggregationPriceProcessor implements Function<Order, Order> {
    @Override
    public Order apply(Order order) {
        return order.setAmout(order.getOrderLines().stream()
                .map(OrderLine::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add));
    }
}
