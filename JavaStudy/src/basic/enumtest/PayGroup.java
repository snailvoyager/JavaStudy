package basic.enumtest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum PayGroup {
    CASH("현금", Arrays.asList(PayType.ACCOUNT_TRANSFER, PayType.REMITTANCE, PayType.ON_SITE_PAYMENT, PayType.TOSS)),
    CARD("카드", Arrays.asList(PayType.PAYCO, PayType.CARD, PayType.KAKAO_PAY, PayType.NAVER_PAY)),
    ETC("기타", Arrays.asList(PayType.POINT, PayType.COUPON)),
    EMPTY("없음", Collections.EMPTY_LIST);

    private final String title;
    private final List<PayType> payList;

    PayGroup(String title, List<PayType> payList) {
        this.title = title;
        this.payList = payList;
    }

    public static PayGroup findByPayType(PayType payType) throws Exception {    //상수들을 순회하며 탐색
        return Arrays.stream(values())
                .filter(paygroup -> paygroup.hasPayCode(payType))
                .findAny()
                .orElseThrow(() -> new Exception("Not Exists."));
    }

    public boolean hasPayCode(PayType payType) {
        return payList.stream()
                .anyMatch(pay -> pay == payType);
    }

    public String getTitle() {
        return title;
    }
}
