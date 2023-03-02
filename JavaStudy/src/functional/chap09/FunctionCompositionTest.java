package functional.chap09;

import functional.chap09.model.Order;
import functional.chap09.model.OrderLine;
import functional.chap09.priceprocessor.OrderLineAggregationPriceProcessor;
import functional.chap09.priceprocessor.TaxiPriceProcessor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionCompositionTest {
    public static void main(String[] args) {
        Function<Integer, Integer> muliplyByTwo = x -> 2 * x;
        Function<Integer, Integer> addTen = x -> x + 10;

        Function<Integer, Integer> composedFunction = muliplyByTwo.andThen(addTen);
        System.out.println(composedFunction.apply(3));

        Order unprocessedOrder = new Order()
                .setId(1001L)
                .setOrderLines(Arrays.asList(new OrderLine().setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(2000))));

        List<Function<Order, Order>> priceProcessors = getPriceProcessors();

        Function<Order, Order> mergedPriceProcessors = priceProcessors.stream()
                .reduce(Function.identity(), (priceProcessors1, priceProcessors2) -> priceProcessors1.andThen(priceProcessors2));

        Order processedOrder = mergedPriceProcessors.apply(unprocessedOrder);
        System.out.println(processedOrder);
    }

    public static List<Function<Order, Order>> getPriceProcessors() {
        return Arrays.asList(new OrderLineAggregationPriceProcessor(),
                new TaxiPriceProcessor(new BigDecimal("9.375")));
    }
}
