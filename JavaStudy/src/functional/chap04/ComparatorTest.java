package functional.chap04;

import functional.chap04.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User(3, "Kim"));
        users.add(new User(5, "Park"));
        users.add(new User(1, "Lee"));

        System.out.println(users);

        Comparator<User> idComparator = (u1, u2) -> u1.getId() - u2.getId();    //u1 < u2 ? -1 : 1 ASC
        Collections.sort(users, idComparator);
        System.out.println(users);

        Collections.sort(users, (u1, u2) -> u1.getName().compareTo(u2.getName()));
        System.out.println(users);
    }
}
