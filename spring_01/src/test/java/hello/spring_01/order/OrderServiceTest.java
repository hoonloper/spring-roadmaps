package hello.spring_01.order;

import hello.spring_01.member.Grade;
import hello.spring_01.member.Member;
import hello.spring_01.member.MemberService;
import hello.spring_01.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
  MemberService memberService = new MemberServiceImpl();
  OrderService orderService = new OrderServiceImpl();

  @Test
  void createOrder() {
    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberId, "itemA", 10_000);
    Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1_000);
  }
}
