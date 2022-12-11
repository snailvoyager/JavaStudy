package effective.item01;

public class Foo {
    String name;
    String address;

    public Foo() {
    }

    public Foo(String name) {
        this.name = name;
    }

    /*public Foo(String address) {      //시그니처가 동일한 생성자 불가
        this.address = address;
    }*/

    public static Foo withName(String name) {   //정적 팩터리 메서드
        return new Foo(name);
    }

    public static Foo withAddress(String address) { //
        Foo foo = new Foo();
        foo.address = address;
        return foo;
    }

    public static void main(String[] args) {
        Foo foo = new Foo("kkk");

        Foo foo2 = Foo.withName("kkk2");
    }
}
