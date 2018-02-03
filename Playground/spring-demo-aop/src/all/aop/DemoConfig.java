package all.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration 
@EnableAspectJAutoProxy
@ComponentScan("all")
public class DemoConfig {

}
