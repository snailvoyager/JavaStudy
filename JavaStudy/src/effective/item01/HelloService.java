package effective.item01;

public interface HelloService {
    String hello();

    static HelloService of(String lang) {   //입력 매개변수에 따라 다른 클래스의 객체를 반환할 수 있다
        if (lang.equals("ko")) {
            return new KoreanHelloService();    //반환 타입의 하위 타입 객체를 반환할 수 있다
        } else {
            return new EnglishHelloService();
        }
    }

}
