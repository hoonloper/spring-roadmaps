package hello.spring_01.discount;

import hello.spring_01.member.Member;

public interface DiscountPolicy {
  /**
   *
   * @return 할인 대상 금액
   */
  int discount(Member member, int price);
}
