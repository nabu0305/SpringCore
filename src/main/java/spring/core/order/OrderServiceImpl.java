package spring.core.order;

import org.springframework.beans.factory.annotation.Autowired;
import spring.core.discount.DiscountPoilcy;
import spring.core.discount.FixDiscountPolicy;
import spring.core.discount.RateDiscountPolicy;
import spring.core.member.Member;
import spring.core.member.MemberRepository;
import spring.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private MemberRepository memberRepository;
    private DiscountPoilcy discountPolicy;
    @Autowired
    public void init(MemberRepository memberRepository, DiscountPoilcy
            discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName,itemPrice,discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
