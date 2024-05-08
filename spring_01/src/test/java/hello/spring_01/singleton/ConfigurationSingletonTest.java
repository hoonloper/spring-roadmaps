package hello.spring_01.singleton;

import hello.spring_01.AppConfig;
import hello.spring_01.member.MemberRepository;
import hello.spring_01.member.MemberServiceImpl;
import hello.spring_01.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ConfigurationSingletonTest {
  @Test
  void configurationTest() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    MemberServiceImpl memberService = ac.getBean(MemberServiceImpl.class);
    OrderServiceImpl orderService = ac.getBean(OrderServiceImpl.class);
    MemberRepository memberRepository = ac.getBean(MemberRepository.class);

    MemberRepository memberRepository1 = memberService.getMemberRepository();
    MemberRepository memberRepository2 = orderService.getMemberRepository();

    System.out.println("memberRepository = " + memberRepository);
    System.out.println("memberRepository1 = " + memberRepository1);
    System.out.println("memberRepository2 = " + memberRepository2);

    Assertions.assertThat(memberRepository1).isSameAs(memberRepository2);
  }

  @Test
  void configurationDeep() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    AppConfig appConfig = ac.getBean(AppConfig.class);

    System.out.println("appConfig = " + appConfig.getClass());
  }
}
