package hello.spring_01;

import hello.spring_01.discount.FixDiscountPolicy;
import hello.spring_01.member.MemberService;
import hello.spring_01.member.MemberServiceImpl;
import hello.spring_01.member.MemoryMemberRepository;
import hello.spring_01.order.OrderService;
import hello.spring_01.order.OrderServiceImpl;

public class AppConfig {
  public MemberService memberService() {
    return new MemberServiceImpl(new MemoryMemberRepository());
  }

  public OrderService orderService() {
    return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
  }
}
