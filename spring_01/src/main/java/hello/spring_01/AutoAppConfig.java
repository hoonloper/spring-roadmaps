package hello.spring_01;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

//@Configuration
//@ComponentScan(
  // default package는 이 class가 존재하는 패키지의 하위 모든 Component를 스캔한다.
  // 즉 패키지 위치를 지정하지 않고, 설정 정보 클래스의 위치를 프로젝트 최상단에 두는 것, 최근 스프링 부트도 이 방법을 기본으로 제공
//  basePackages = "hello.spring_01.member",
//  basePackageClasses = AutoAppConfig.class,
//  excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
//)
//class AutoAppConfig {
//}
