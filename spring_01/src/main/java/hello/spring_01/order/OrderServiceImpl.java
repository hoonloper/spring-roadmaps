package hello.spring_01.order;

import hello.spring_01.discount.DiscountPolicy;
import hello.spring_01.discount.FixDiscountPolicy;
import hello.spring_01.member.Member;
import hello.spring_01.member.MemberRepository;
import hello.spring_01.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
  private final MemberRepository memberRepository = new MemoryMemberRepository();
  private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);

    return new Order(memberId, itemName, itemPrice, discountPrice);
  }
}
