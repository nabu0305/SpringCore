package spring.core.order;

import spring.core.discount.DiscountPoilcy;
import spring.core.discount.FixDiscountPolicy;
import spring.core.member.Member;
import spring.core.member.MemberRepository;
import spring.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPoilcy discountPoilcy = new FixDiscountPolicy();



    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPoilcy.discount(member, itemPrice);

        return new Order(memberId, itemName,itemPrice,discountPrice);
    }
}
