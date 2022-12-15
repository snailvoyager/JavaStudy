package effective.item02;

import java.util.Objects;

public class NyPizza extends Pizza{
    public enum Size {
        SMALL,
        MEDIUM,
        LARGE
    }
    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {    //부모의 Builder 클래스를 상속하여 구현
        private final Size size;
        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }
        @Override
        public NyPizza build() { //구체 빌더
            return new NyPizza(this);   //각 생성자를 호출
        }

        @Override
        protected Builder self() {
            return this;
        }   //this는 NyPizza.Builder
    }
    private NyPizza(Builder builder) {  //생성자는 private으로 Builder 클래스를 호출하여 생성
        super(builder);     //부모 Pizza에 기본생성자가 없기 때문에 부모 생성자 호출
        size = builder.size;
    }
}
