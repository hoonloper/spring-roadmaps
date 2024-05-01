package hello.spring_01;

import hello.spring_01.member.Grade;
import hello.spring_01.member.Member;
import hello.spring_01.member.MemberService;
import hello.spring_01.member.MemberServiceImpl;
import hello.spring_01.order.Order;
import hello.spring_01.order.OrderService;
import hello.spring_01.order.OrderServiceImpl;

public class OrderApp {
  public static void main(String[] args) {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberId, "itemA", 10_000);

    System.out.println("order = " + order);
  }
}
