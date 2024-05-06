package hello.spring_01.order;

import hello.spring_01.discount.DiscountPolicy;
import hello.spring_01.member.Member;
import hello.spring_01.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
  private final MemberRepository memberRepository;
  private final DiscountPolicy discountPolicy;

  /**
   * @Autowired 매칭 정리
   * 1. 타입 매칭
   * 2. 타입 매칭의 결과가 2개 이상일 때 필드명, 파라미터명으로 빈 이름 매칭
   *
   * @Qualifier
   * 추가 구분자를 붙여주는 방법
   * 주입 시 추가적인 방법을 제공하는 것이지 빈 이름을 변경하는 것은 아니다
   * Qualifier는 Qualifier를 찾는 용도로만 사용하는 게 좋다
   *
   * @Primary
   * 우선순위를 정하는 방법이다. @Autowired 시에 여러 빈이 조회되면 @Primary가 우선권을 가진다
   *
   * # @Qualifier, @Primary
   * 코드에서 자주 사용하는 메인 데이터베이스의 커넥션을 획득하는 스프링 빈이 있고,
   * 코드에서 특별한 기능으로 가끔 사용하는 서브 데이터베이스의 커넥션을 획득하는 스프링 빈이 있다고 생각해보자
   * 메인 데이터베이스의 커넥션을 획득하는 스프링 빈은 @Primary를 적용해서 조회하는 곳에서 @Qualifier 지정 없이 편리하게 조회하고,
   * 서브 데이터베이스 커넥션 빈을 획득할 때는 @Qualifier를 지정해서 명시적으로 획득하는 방식으로 사용하면 코드를 깔끔하게 유지할 수 있다
   * 물론 이때 메인 데이터베이스의 스프링 빈을 등록할 때 @Qualifier를 지정해주는 것은 상관없다
   * [우선순위]
   * -> @Primary는 기본값 처럼 동작하는 것이고, @Quailifier는 매우 상세하게 동작한다.
   * 이런 경우 어떤 것이 우선권을 가져갈까? 스프링은 자동보다는 수동이, 넓은 범위의 선택권 보다는 좁은 범위의 선택권이 우선 순위가 높다.
   * 따라서 여기서도 @Quailifier가 우선권이 높다
   */
  @Autowired
  public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy;
  }
  /**
   * 생성자 주입 방식을 선택하는 이유 여러가지가 있지만, 프레임워크에 의존하지 않고, 순수한 자바 언어의 특징을 잘 살리는 방법이기도 하다.
   * 기본적으로 생성자 주입을 사용하고, 필수 값이 아닌 경우에는 수정자 주입 방식을 옵션으로 부여하면 된다.
   * 생성자 주입과 수정자 주입을 동시에 사용할 수 있다.
   * 항상 생성자 주입을 선택해라! 그리고 가끔 옵션이 필요하면 수정자 주입을 선택해라. 필드 주입은 사용하지 않는 게 좋다.
   */
//  public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//    this.memberRepository = memberRepository;
//    this.discountPolicy = discountPolicy;
//  }

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);

    return new Order(memberId, itemName, itemPrice, discountPrice);
  }

  // 테스트 용도
  public MemberRepository getMemberRepository() {
    return memberRepository;
  }
}
