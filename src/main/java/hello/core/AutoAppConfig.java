package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 해당 파라미터를 통해서 컴포넌트 스캔 범위를 패키지 단위로 지정할 수 있다. default 는 현재 코드가 작성된 package hello.core 부터 하위패키지를 모두 검색
//        basePackages = "hello.core.member",

        // 예제를 활용하기 위해서 기본 AppConfig 는 제외 시킨다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
