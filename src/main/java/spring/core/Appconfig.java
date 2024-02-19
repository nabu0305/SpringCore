package spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.core.discount.DiscountPoilcy;
import spring.core.discount.FixDiscountPolicy;
import spring.core.discount.RateDiscountPolicy;
import spring.core.member.MemberRepository;
import spring.core.member.MemberService;
import spring.core.member.MemberServiceImpl;
import spring.core.member.MemoryMemberRepository;
import spring.core.order.OrderService;
import spring.core.order.OrderServiceImpl;

@Configuration //구성정보를 담당하는 뜻의 그 파일, 그 설정 정보
public class Appconfig {

    @Bean
    public MemberService memberService(){
        System.out.println("call Appconfig.memberService");
        return new MemberServiceImpl(memberRepository());//생성자 주입
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call Appconfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call Appconfig.orderService");
//        return new OrderServiceImpl(memberRepository(), discountPolicy());
        return null;
    }

    @Bean
    public DiscountPoilcy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
