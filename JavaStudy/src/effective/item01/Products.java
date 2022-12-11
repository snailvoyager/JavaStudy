package effective.item01;

public class Products {
    public static void main(String[] args) {
        Settings settings1 = Settings.newInstance();
        Settings settings2 = Settings.newInstance();

        System.out.println(settings1);
        System.out.println(settings2);
        System.out.println(settings1 == settings2);
    }
}
