package functional.chap06;

import functional.chap06.model.Order;
import functional.chap06.model.OrderLine;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapTest {
    public static void main(String[] args) {
        String[][] cities = new String[][] {
                {"Seoul", "Busan"},
                {"SanFrancisco", "New York"},
                {"Madrid", "Barcelona"}
        };

        Stream<String[]> cityStream = Arrays.stream(cities);
        Stream<Stream<String>> cityStreamStream = cityStream.map(x -> Arrays.stream(x));
        List<Stream<String>> cityStreamList =  cityStreamStream.collect(Collectors.toList());

        Stream<String[]> cityStream2 = Arrays.stream(cities);
        Stream<String> flattenedCityStream = cityStream2.flatMap(x -> Arrays.stream(x));
        List<String> flattenedCityList = flattenedCityStream.collect(Collectors.toList());
        System.out.println(flattenedCityList);

        Order order1 = new Order()
                .setId(1001)
                .setOrderLines(Arrays.asList(new OrderLine()
                                                    .setId(10001)
                                                    .setType(OrderLine.OrderLineType.PURCHASE)
                                                    .setAmout(BigDecimal.valueOf(5000)),
                                            new OrderLine()
                                                    .setId(10002)
                                                    .setType(OrderLine.OrderLineType.PURCHASE)
                                                    .setAmout(BigDecimal.valueOf(4000))
                ));
        Order order2 = new Order()
                .setId(1002)
                .setOrderLines(Arrays.asList(new OrderLine()
                                .setId(10003)
                                .setType(OrderLine.OrderLineType.PURCHASE)
                                .setAmout(BigDecimal.valueOf(2000)),
                        new OrderLine()
                                .setId(10004)
                                .setType(OrderLine.OrderLineType.DISCOUNT)
                                .setAmout(BigDecimal.valueOf(-1000))    //1000 discount
                ));
        Order order3 = new Order()
                .setId(1003)
                .setOrderLines(Arrays.asList(new OrderLine()
                                .setId(10005)
                                .setType(OrderLine.OrderLineType.PURCHASE)
                                .setAmout(BigDecimal.valueOf(2000))
                ));

        List<Order> orders = Arrays.asList(order1, order2, order3);
        List<OrderLine> mergedOrderLines = orders.stream()      //Stream<Order>
                .map(Order::getOrderLines)                      //Stream<List<OrderLine>>   Order.OrderLines 추출해서
                .flatMap(List::stream)                          //Stream<OrderLine>         스트림으로 변환
                .collect(Collectors.toList());
        System.out.println(mergedOrderLines);
    }
}
