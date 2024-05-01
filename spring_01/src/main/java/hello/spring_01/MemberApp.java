package hello.spring_01;

import hello.spring_01.member.Grade;
import hello.spring_01.member.Member;
import hello.spring_01.member.MemberService;
import hello.spring_01.member.MemberServiceImpl;

public class MemberApp {
  public static void main(String[] args) {
    MemberService memberService = new MemberServiceImpl();
    Member member = new Member(1L, "memberA", Grade.VIP);
    memberService.join(member);

    Member foundMember = memberService.findMember(1L);
    System.out.println("foundMember = " + foundMember.getName());
    System.out.println("member = " + member.getName());
  }
}
