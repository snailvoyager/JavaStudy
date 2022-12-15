package effective.item02;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {
    public enum Topping {
        HAM,
        MUSHROOM,
        ONION,
        PEPPER,
        SAUSAGE
    }

    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {   //계층적 빌더
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping) {  //하위 클래스에서 공통으로 사용할 토핑
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build(); //추상 빌더

        protected abstract T self();    //하위 클래스는 overriding하여 this를 반환
    }

    //build() 호출할 때 하위 클래스의 생성자에서 super()를 호출하고
    //부모 생성자에서 enum 값을 clone해서 저장
    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();    //Item50
    }
}
