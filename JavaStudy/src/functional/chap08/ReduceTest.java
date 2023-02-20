package functional.chap08;

import functional.chap08.model.Order;
import functional.chap08.model.OrderLine;
import functional.chap08.model.User;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ReduceTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 4, -2, -5, 3);
        int sum = numbers.stream()
                .reduce((x, y) -> x + y)
                .get();
        System.out.println(sum);

        int min = numbers.stream()
                .reduce((x, y) -> x < y ? x : y).get();
        System.out.println(min);

        int product = numbers.stream()
                .reduce(1, (x, y) -> x * y);
        System.out.println(product);

        List<String> numberStrList = Arrays.asList("3", "2", "5", "-4");
        int sumOfNumberStrList = numberStrList.stream()
                .map(Integer::parseInt)
                .reduce(0, (x,y) -> x+y);

        int sumOfNumberStrList2 = numberStrList.stream()
                        .reduce(0, (number, str) -> number + Integer.parseInt(str), (num1,num2) -> num1 + num2);

        System.out.println(sumOfNumberStrList);

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

        //User.FriendUserIds 총 갯수
        int sumOfNumberOfFriends = users.stream()
                .map(User::getFriendUserIds)
                .map(List::size)
                .reduce(0, (x,y) -> x + y);
        System.out.println(sumOfNumberOfFriends);

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
        //sum of amounts
        BigDecimal sumOfAmounts = orders.stream()
                .map(Order::getOrderLines)
                .flatMap(List::stream)
                .map(OrderLine::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(sumOfAmounts);
    }
}
