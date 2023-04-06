package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient {
//public class NetworkClient implements InitializingBean , DisposableBean {
    // 초기화, 소멸 인터페이스 단점
    // - 이 인터페이스는 스프링 전용 인터페이스다. 해당 코드가 스프링 전용 인터페이스에 의존한다.
    // 초기화, 소멸 메서드의 이름을 변경할 수 없다.
    // 내가 코드를 고칠 수 없는 외부 라이브러리에 적용할 수 없다.

    private String url;

    public NetworkClient(){
        System.out.println("[생성자 호출] url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect(){
        System.out.println("[connect] " + url);
    }

    public void call(String message){
        System.out.println("call: " + url + " message = " + message);
    }

    // 서비스 종료시 호출
    public void disconnect() {
        System.out.println("[종료] close : " + url);
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
        // 의존관계 주입이 끝나면 호출된다.
    public void init() {
        System.out.println("[AfterProperty]");
        connect();
        call("초기화 연결 메세지");
    }

//    @Override
//    public void destroy() throws Exception {
    public void close() {
        System.out.println("[destroy]");
        disconnect();
    }
}
