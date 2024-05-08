package hello.spring_01.web;

import hello.spring_01.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class LogDemoService {
  private final MyLogger myLogger;

  public void logic(String id) {
    myLogger.log("service id = " + id);
  }
}
