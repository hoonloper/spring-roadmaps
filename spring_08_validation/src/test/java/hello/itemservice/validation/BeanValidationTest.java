package hello.itemservice.validation;

import hello.itemservice.domain.item.Item;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@SpringBootTest
public class BeanValidationTest {
  @Test
  void beanValidation() {
    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    Validator validator = validatorFactory.getValidator();

    Item item = new Item();
    item.setItemName("");
    item.setPrice(0);
    item.setQuantity(10000);

    Set<ConstraintViolation<Item>> violations = validator.validate(item);

    for (ConstraintViolation<Item> violation: violations) {
      System.out.println("violation = " + violation);
      System.out.println("violation.message = " + violation.getMessage());
    }
  }
}
