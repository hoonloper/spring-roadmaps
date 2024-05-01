package hello.spring_01.member;

public class MemberServiceImpl implements MemberService {
  private final MemberRepository memberRepository = new MemoryMemberRepository();
  @Override
  public void join(Member member) {
    memberRepository.save(member);
  }

  @Override
  public Member findMember(Long memberId) {
    return memberRepository.findById(memberId);
  }
}