package api;

import java.util.HashMap;
import java.util.Objects;

public class HashCode {

    public static void main(String[] args) {
        String a = "Z@S.ME";
        String b = "Z@RN.E";
        System.out.println(a.equals(b));       //false
        System.out.println(a.hashCode());      //equals() false인데 hashCode는 같다
        System.out.println(b.hashCode());

        HashMap<String, String> map = new HashMap<>();
        map.put(a, "a");        //equals 값이 false 이기 때문에 Key 값은 다르게 처리
        map.put(b, "b");

        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }

        Node n1 = new Node("n1");
        Node n2 = new Node("n1");
        System.out.println(n1.equals(n2));
        System.out.println(n1.hashCode());
        System.out.println(n2.hashCode());

        HashMap<Node, Integer> nodeMap = new HashMap<>();
        nodeMap.put(n1, 1);     //equals, hashCode가 모두 같아야 같은 Key 값으로 처리
        nodeMap.put(n2, 2);
        System.out.println(nodeMap.size());
        System.out.println(nodeMap.get(n1));
        System.out.println(nodeMap.get(n2));
    }
}

class Node {
    String id;

    Node(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(id, node.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
