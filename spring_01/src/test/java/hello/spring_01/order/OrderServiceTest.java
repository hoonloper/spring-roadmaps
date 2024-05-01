package hello.spring_01.order;

import hello.spring_01.AppConfig;
import hello.spring_01.member.Grade;
import hello.spring_01.member.Member;
import hello.spring_01.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
  MemberService memberService;
  OrderService orderService;

  @BeforeEach
  public void beforeEach() {
    AppConfig appConfig = new AppConfig();
    memberService = appConfig.memberService();
    orderService = appConfig.orderService();
  }

  @Test
  void createOrder() {
    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberId, "itemA", 10_000);
    Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1_000);
  }
}
