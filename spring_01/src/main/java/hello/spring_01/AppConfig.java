package hello.spring_01;

import hello.spring_01.discount.DiscountPolicy;
import hello.spring_01.discount.FixDiscountPolicy;
import hello.spring_01.discount.RateDiscountPolicy;
import hello.spring_01.member.MemberRepository;
import hello.spring_01.member.MemberService;
import hello.spring_01.member.MemberServiceImpl;
import hello.spring_01.member.MemoryMemberRepository;
import hello.spring_01.order.OrderService;
import hello.spring_01.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//class AppConfig {
//  @Bean
//  public MemberService memberService() {
//    System.out.println("AppConfig.memberService");
//    return new MemberServiceImpl(memberRepository());
//  }
//
//  @Bean
//  public OrderService orderService() {
//    System.out.println("AppConfig.orderService");
//    return new OrderServiceImpl(memberRepository(), discountPolicy());
//  }
//
//  @Bean
//  public MemberRepository memberRepository() {
//    System.out.println("AppConfig.memberRepository");
//    return new MemoryMemberRepository();
//  }
//
//  @Bean
//  public DiscountPolicy discountPolicy() {
////    return new FixDiscountPolicy();
//    return new RateDiscountPolicy();
//  }
//}
