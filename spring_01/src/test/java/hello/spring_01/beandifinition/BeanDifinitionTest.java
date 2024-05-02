package hello.spring_01.beandifinition;

import hello.spring_01.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

class BeanDifinitionTest {
//  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
  GenericXmlApplicationContext ac = new GenericXmlApplicationContext(AppConfig.class);

  @Test
  @DisplayName("빈 설정 메타정보 확인")
  void findApplicationBean() {
    String[] beanDefinitionNames = ac.getBeanDefinitionNames();

    for (String beanDefinitionName : beanDefinitionNames) {
      BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

      if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
        System.out.println("beanDefinitionName = " + beanDefinitionName + "beanDefinition = " + beanDefinition);
      }
    }
  }
}
