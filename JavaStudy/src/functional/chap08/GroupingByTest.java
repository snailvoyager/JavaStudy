package functional.chap08;

import functional.chap08.model.Order;
import functional.chap08.model.OrderLine;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupingByTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(13, 2, 101, 203, 304, 402, 305, 349, 2312, 203);
        Map<Integer, List<Integer>> unitDigitMap = numbers.stream()
                .collect(Collectors.groupingBy(number -> number % 10));
        System.out.println(unitDigitMap);

        Map<Integer, Set<Integer>> unitDigitSet = numbers.stream()
                .collect(Collectors.groupingBy(number -> number % 10, Collectors.toSet()));
        System.out.println(unitDigitSet);   //중복 제거

        Map<Integer, List<String>> unitDigitStrMap = numbers.stream()
                .collect(Collectors.groupingBy(number -> number % 10,
                        Collectors.mapping(number -> "unit digit is " + number, Collectors.toList())));
        System.out.println(unitDigitStrMap);

        Order order1 = new Order()
                .setId(1001)
                .setStatus(Order.OrderStatus.CREATED)
                .setCreatedByUserId(101)
                .setAmout(BigDecimal.valueOf(5000));
        Order order2 = new Order()
                .setId(1002)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(103)
                .setAmout(BigDecimal.valueOf(3000));
        Order order3 = new Order()
                .setId(1003)
                .setStatus(Order.OrderStatus.PROCESSED)
                .setCreatedByUserId(102)
                .setAmout(BigDecimal.valueOf(4000));
        Order order4 = new Order()
                .setId(1004)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(104)
                .setAmout(BigDecimal.valueOf(7000));
        Order order5 = new Order()
                .setId(1005)
                .setStatus(Order.OrderStatus.IN_PROGRESS)
                .setCreatedByUserId(101)
                .setAmout(BigDecimal.valueOf(6000));

        List<Order> orders = Arrays.asList(order1,order2,order3,order4,order5);
        Map<Order.OrderStatus, List<Long>> orderStatusToOrderMap = orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus,
                        Collectors.mapping(Order::getId, Collectors.toList())));
        System.out.println(orderStatusToOrderMap);

        Map<Order.OrderStatus, BigDecimal> orderStatusToSumOfAmountMap = orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus,
                        Collectors.mapping(Order::getAmout,
                                Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)))); //총 합
        System.out.println(orderStatusToSumOfAmountMap);
    }
}
