package hello.spring_01.discount;

import hello.spring_01.member.Grade;
import hello.spring_01.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("fixDiscountPolicy")
class FixDiscountPolicy implements DiscountPolicy {
  private int discountFixAmount = 1_000;

  @Override
  public int discount(Member member, int price) {
    // enum 타입은 == 쓰는 게 좋다.
    if (member.getGrade() == Grade.VIP) {
      return discountFixAmount;
    }

    return 0;
  }
}
