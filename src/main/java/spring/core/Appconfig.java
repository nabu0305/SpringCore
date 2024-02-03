package spring.core;

import spring.core.discount.FixDiscountPolicy;
import spring.core.member.MemberService;
import spring.core.member.MemberServiceImpl;
import spring.core.member.MemoryMemberRepository;
import spring.core.order.OrderService;
import spring.core.order.OrderServiceImpl;

public class Appconfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());//생성자 주입
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
