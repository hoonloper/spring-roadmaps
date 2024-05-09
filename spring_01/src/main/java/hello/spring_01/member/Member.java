package hello.spring_01.member;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
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
