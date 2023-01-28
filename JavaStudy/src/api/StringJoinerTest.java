package api;

import java.util.*;

public class StringJoinerTest {
    public static void main(String[] args) {
        List<String> titles = List.of("[상품1] 키즈 장난감", "[상품2] 중학생 책가방", "[상품3] 중학생  노트북");

        LinkedHashSet<String> set = new LinkedHashSet<>();
        titles.forEach(x -> set.addAll(Set.of(x.split(" "))));   //Arrays.asList -> Set.of (불변) split은 null이 아니라 공백 포함.

        StringBuilder sb = new StringBuilder();
        for (String s : set) {
            sb.append(s).append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);

        //StringJoiner
        StringJoiner sj = new StringJoiner(",");
        for (String s : set) {
            sj.add(s);
        }
        System.out.println(sj);

        //String.join
        System.out.println(String.join(",", set));
    }
}
