package hello.spring_01.life_cycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

// public class NetworkClient implements InitializingBean, DisposableBean {
public class NetworkClient {
  private String url;

  /**
   * 참고: 객체의 생성과 초기화를 분리하자.
   * 생성자는 필수 정보(파라미터)를 받고, 메모리를 할당해서 객체를 생성하는 책임을 가진다.
   * 반면에 초기화는 이렇게 생성된 값들을 활용해서 외부 커넥션을 연결하는 등 무거운 동작을 수행한다.
   * 따라서 생성자 안에서 무거운 초기화 작업을 함께 하는 것 보다는 객체를 생성하는 부분과 초기화 하는 부분을 명확하게 나누는 것이 유지보수 관점에서 좋다.
   * 물론 초기화 작업이 내부 값들만 약간 변경하는 정도로 단순한 경우에는 생성자에서 한번에 다 처리하는 게 더 나을 수 있다.
   */
  /**
   * 스프링은 크게 3가지 방법으로 빈 생명주기 콜백을 지원한다.
   * - 인터페이스(InitializingBean, DisposableBean)
   * - 설정 정보에 초기화 메서드, 종료 메서드 지정
   * - @PostConstruct, @PreDestroy 애노테이션 지원
   */
  public NetworkClient() {
    System.out.println("생성자 호출, url = " + url);
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public void connect() {
    System.out.println("connect: " + url);
  }

  public void call(String message) {
    System.out.println("call: " + url + " message = " + message);
  }

  public void disconnect() {
    System.out.println("close " + url);
  }

  public void init() {
    connect();
    call("초기화 연결 메시지");
  }

  public void close() {
    disconnect();
  }

  /**
   * 초기화, 소멸 인터페이스 단점
   * 이 인터페이스는 스프링 전용 인터페이스다. 해당 코드가 스프링 전용 인터페이스에 의존한다.
   * 초기화, 소멸 메서드의 이름을 변경할 수 없다.
   * 내가 코드를 고칠 수 없는 외부 라이브러리에 적용할 수 없다.
   *
   * 참고
   * 인터페이스를 사용하는 초기화, 종료 방법은 스프링 초창기에 나온 방법들이고, 지금은 다음의 더 나은 방법들이 있어 거의 사용하지 않는다.
   */
  // 의존관계 설정이 끝나면 호출
//  @Override
//  public void afterPropertiesSet() throws Exception {
//    System.out.println("NetworkClient.afterPropertiesSet");
//    connect();
//    call("초기화 연결 메시지");
//  }
//
//  // 애플리케이션 종료 시 호출
//  @Override
//  public void destroy() throws Exception {
//    System.out.println("NetworkClient.destroy");
//    disconnect();
//  }
}
