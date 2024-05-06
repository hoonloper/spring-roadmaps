package hello.spring_01;

import hello.spring_01.member.Grade;
import hello.spring_01.member.Member;
import hello.spring_01.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
  public static void main(String[] args) {
//    AppConfig appConfig = new AppConfig();
//    MemberService memberService = appConfig.memberService();

//    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//    MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
//
//    Member member = new Member(1L, "memberA", Grade.VIP);
//    memberService.join(member);
//
//    Member foundMember = memberService.findMember(1L);
//    System.out.println("foundMember = " + foundMember.getName());
//    System.out.println("member = " + member.getName());
  }
}
