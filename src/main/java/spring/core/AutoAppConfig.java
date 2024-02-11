package spring.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "spring.core.member",
        excludeFilters =  @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) //@붙은 에노테이션을 다 찾아서 스프링 빈으로 자동등록
public class AutoAppConfig {
    
}
