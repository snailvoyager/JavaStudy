package effective.item01;

import java.util.Optional;
import java.util.ServiceLoader;

public class HelloServiceFactory {
    public static void main(String[] args) {
        HelloService ko = HelloService.of("ko");
        System.out.println(ko.hello());

        HelloService en = HelloService.of("en");
        System.out.println(en.hello());

        ServiceLoader<HelloService> loader = ServiceLoader.load(HelloService.class);    //등록되어있는 구현체를 모두 불러옴
        Optional<HelloService> helloServiceOptional = loader.findFirst();
        helloServiceOptional.ifPresent(h -> {
            System.out.println(h.hello());
        });     //구현체에 의존적이지 않고, 분리하여 구현 가능
        //정적 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다
    }
}
