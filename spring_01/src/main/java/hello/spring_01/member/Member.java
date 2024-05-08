package hello.spring_01.member;

import lombok.Data;

@Data
class Member {
  private Long id;
  private String name;
  private Grade grade;

  public Member(Long id, String name, Grade grade) {
    this.id = id;
    this.name = name;
    this.grade = grade;
  }
}
