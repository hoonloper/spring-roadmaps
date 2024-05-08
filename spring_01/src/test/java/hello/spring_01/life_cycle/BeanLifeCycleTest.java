package hello.spring_01.life_cycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

 @Test
  public void lifeCycleTest() {
    ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);

    NetworkClient client = ac.getBean(NetworkClient.class);

    ac.close();
  }

  @Configuration
  static class LifeCycleConfig {
    /**
     * 설정 정보 사용 특징 - @Bean(initMethod = "init", destroyMethod = "close")
     * 메서드 이름을 자유롭게 줄 수 있다.
     * 스프링 빈이 스프링 코드에 의존하지 않는다
     * 코드가 아니라 설정 정보를 사용하기 때문에 코드를 고칠 수 없는 외부 라이브러리에도 초기화, 종료 메서드를 적용할 수 있다.
     *
     * destroyMethod에는 특별한 기능이 있다.
     * - 라이브러리는 대부분 close, shutdown 이라는 이름의 종료 메서드를 사용한다
     * - @Bean의 destroymethod는 기본값이 (inferred) 추론으로 등록되어 있다
     * - 이 추론 기능은 close, shutdown라는 이름의 메서드를 자동으로 호출해준다.
     * - 이름 그대로 종료 메서드를 추론해서 호출해준다.
     * - 따라서 직접 스프링 빈으로 등록하면 종료 메서드는 따로 적어주지 않아도 잘 동작한다.
     * - 추론 기능을 사용하기 싫으면 destroyMethod를 공백 문자열("")로 지정하면 된다.
     */
//    @Bean(initMethod = "init", destroyMethod = "close")
    @Bean
    public NetworkClient networkClient() {
      NetworkClient networkClient = new NetworkClient();
      networkClient.setUrl("http://hello-spring.dev");

      return networkClient;
    }
  }
}
