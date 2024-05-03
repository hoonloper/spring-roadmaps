package hello.spring_01.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
  @Test
  @DisplayName("")
  void statefulServiceSingleton() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
    StatefulService statefulService1 = ac.getBean(StatefulService.class);
    StatefulService statefulService2 = ac.getBean(StatefulService.class);

    // ThreadA: A User 100000
    statefulService1.order("userA", 100000);

    // ThreadB: B User 200000
    statefulService2.order("userB", 200000);

    // ThreadA: A User get order price
    int price1 = statefulService1.getPrice();

    // ThreadB: A User get order price
    int price2 = statefulService2.getPrice();

    System.out.println("price1 = " + price1 + "price2 = " + price2);

    Assertions.assertThat(statefulService1.getPrice()).isEqualTo(200000);
  }

  static class TestConfig {
    @Bean
    public StatefulService statefulService() {
      return new StatefulService();
    }
  }
}