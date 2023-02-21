package functional.chap08;

import functional.chap08.model.Order;
import functional.chap08.model.OrderLine;
import functional.chap08.model.User;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToMapTest {
    public static void main(String[] args) {
        Map<Integer, String> numberMap = Stream.of(3, 5, -4, 2, 6)
                .collect(Collectors.toMap(Function.identity(), x -> "Number is " + x));
        System.out.println(numberMap.get(3));

        User user1 = new User()
                .setId(101)
                .setName("Paul")
                .setVerified(true)
                .setEmailAddress("alice@mail.com")
                .setFriendUserIds(Arrays.asList(201, 202, 203, 204));

        User user2 = new User()
                .setId(201)
                .setName("David")
                .setVerified(false)
                .setEmailAddress("bob@mail.com")
                .setFriendUserIds(Arrays.asList(204, 205, 206));

        User user3 = new User()
                .setId(301)
                .setName("John")
                .setVerified(false)
                .setEmailAddress("charlie@mail.com")
                .setFriendUserIds(Arrays.asList(204, 205, 206));

        User user4 = new User()
                .setId(401)
                .setName("Alice")
                .setVerified(false)
                .setEmailAddress("alice@mail.com");

        List<User> users = Arrays.asList(user1, user2, user3);
        Map<Integer, User> userIdToUserMap = users.stream()
                .collect(Collectors.toMap(User::getId, Function.identity()));
        System.out.println(userIdToUserMap);

        Order order1 = new Order()
                .setId(1001)
                .setStatus(Order.OrderStatus.CREATED)
                .setCreatedByUserId(101)
                .setOrderLines(Arrays.asList(new OrderLine().setAmount(BigDecimal.valueOf(2000))));
        Order order2 = new Order()
                .setId(1002)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(103)
                .setAmout(BigDecimal.valueOf(3000))
                .setOrderLines(Arrays.asList(new OrderLine().setAmount(BigDecimal.valueOf(2000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(3000))));
        Order order3 = new Order()
                .setId(1003)
                .setStatus(Order.OrderStatus.PROCESSED)
                .setCreatedByUserId(102)
                .setAmout(BigDecimal.valueOf(4000))
                .setOrderLines(Arrays.asList(new OrderLine().setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(2000))));

        List<Order> orders = Arrays.asList(order1, order2, order3);
        Map<Long, Order.OrderStatus> orderIdToOrderStatusMap = orders.stream()
                .collect(Collectors.toMap(Order::getId, Order::getStatus));
        System.out.println(orderIdToOrderStatusMap);
    }
}
