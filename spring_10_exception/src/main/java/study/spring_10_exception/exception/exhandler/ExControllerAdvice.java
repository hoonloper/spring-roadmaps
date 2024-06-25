package study.spring_10_exception.exception.exhandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import study.spring_10_exception.exception.exception.UserException;

@Slf4j
@RestControllerAdvice
public class ExControllerAdvice {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(IllegalArgumentException.class)
  public ErrorResult illegalExHandle(IllegalArgumentException e) {
    log.error("[exceptionHandle] ex", e);

    return new ErrorResult("BAD", e.getMessage());
  }

  @ExceptionHandler
  public ResponseEntity<ErrorResult> userExHandle(UserException e) {
    log.error("[exceptionHandle] ex", e);

    ErrorResult errorResult = new ErrorResult("USER-EX", e.getMessage());

    return new ResponseEntity<>(errorResult, HttpStatus.BAD_REQUEST);
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler
  public ErrorResult exHandle(Exception e) {
    log.error("[exceptionHandle] ex", e);

    return new ErrorResult("EX", "내부 오류");
  }

  // Target all Controllers annotated with @RestController
  @ControllerAdvice(annotations = RestController.class)
  public class ExampleAdvice1 {}

  // Target all Controllers within specific packages
  @ControllerAdvice("org.example.controllers")
  public class ExampleAdvice2 {}

  // Target all Controllers assignable to specific classes
  @ControllerAdvice(assignableTypes = {ControllerInterface.class, AbstractController.class})
  public class ExampleAdvice3 {}
}
