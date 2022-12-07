package basic.enumtest;

public class PayGroupMain {
    public static void main(String[] args) throws Exception {
        PayGroup payGroup = PayGroup.findByPayType(PayType.NAVER_PAY);
        System.out.println(payGroup);
        System.out.println(payGroup.getTitle());
    }
}
