package spring.core.discount;

import spring.core.member.Member;

public interface DiscountPoilcy {

    /*
    @return 할인 대상 금액
     */
    int discount(Member member,int price);


}
