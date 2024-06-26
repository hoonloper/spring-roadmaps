package hello.spring_01.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

/**
 * Annotation은 상속의 개념이 업삳
 * 이렇게 여러 애노테이션을 모아서 사용하는 기능은 스프링이 지원해주는 기능이다.
 * @qualifier 뿐만 아니라 다른 애노테이션들도 함께 조합해서 사용할 수 있다.
 * 단적으로 @Autowired도 재정의 할 수 있다.
 * 물론 스프링이 제공하는 기능을 뚜렷한 목적 없이 무분별하게 재정의하는 것은 유지보수에 더 혼란만 가중할 수 있다
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {
}
