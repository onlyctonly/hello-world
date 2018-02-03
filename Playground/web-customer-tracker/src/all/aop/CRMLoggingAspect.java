 package all.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* all.*.*.*(..))")
	private void all() {};
	
	@Before("all()")
	private void before(JoinPoint j) {
		String method = j.getSignature().toShortString();
		logger.info(method + " yoyoyo");
		Object[] args = j.getArgs();
		for (Object temparg : args) {
			logger.info(temparg + "\nkukuku");
		}
	}
}
