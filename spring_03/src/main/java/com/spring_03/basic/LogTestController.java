package com.spring_03.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController // @Controller와 차이점은 view name이냐 응답 데이터냐의 차이
public class LogTestController {
//  private final Logger log = LoggerFactory.getLogger(getClass()); -> @Slf4j 롬복으로 대체 가능

  @RequestMapping("/log-test")
  public String logTest() {
    String name = "Spring";

    // + 로 출력하는 것은 좋지 못하다
    // log.info("info log = " + name);
    // log.info("info log = " + "Spring"); 연산 발생
    // log.info("info log = Spring");
    // 로그가 찍히지 않을 경우 필요없는 '+ 연산' 리소스 비용이 발생한다
    // ("log = {}", name) 형태는 로그가 출력될 때 '+ 연산'이 발생하여 조금의 최적화 효과를 가져올 수 있다.
    log.info("info log = " + name);

    log.trace("trace log = {}", name);
    log.debug("debug log = {}", name);
    log.info("info log = {}", name);
    log.warn("warn log = {}", name);
    log.error("error log = {}", name);

    return "ok";
  }
}
