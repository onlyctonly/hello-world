package all.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component 
public class MyDemoLoggingAspect {
	@Before("execution(void add*())")
	public void beforeAddAccountAdvice() {
		System.out.println("i am running before you, ha!");
	}
}
