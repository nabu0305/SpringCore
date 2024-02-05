package spring.core;

import spring.core.discount.DiscountPoilcy;
import spring.core.discount.FixDiscountPolicy;
import spring.core.member.MemberRepository;
import spring.core.member.MemberService;
import spring.core.member.MemberServiceImpl;
import spring.core.member.MemoryMemberRepository;
import spring.core.order.OrderService;
import spring.core.order.OrderServiceImpl;

public class Appconfig {

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());//생성자 주입
    }

    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPoilcy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
