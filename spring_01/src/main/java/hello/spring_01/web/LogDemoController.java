package hello.spring_01.web;

import hello.spring_01.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
  private final LogDemoService logDemoService;
  private final MyLogger myLogger;

  @RequestMapping("log-demo")

  public String logDemo(HttpServletRequest request) {
    String requestURL = request.getRequestURL().toString();

    System.out.println("myLogger = " + myLogger.getClass());

    myLogger.setRequestURL(requestURL);
    myLogger.log("controller test");

    logDemoService.logic("testId");

    return "OK";
  }
}
