package gr.cgw.subscription.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Service
public class ExecutionInterceptor implements HandlerInterceptor {

	private static Logger logger = LoggerFactory.getLogger("execution");
	private long before=0;
	private long after=0;
	private long post=0;
	private long total=0;
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		after=System.currentTimeMillis();
		total=after-before;
		logger.info("total: "+ total);
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		post=System.currentTimeMillis();
		logger.info("post: "+post);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		before=System.currentTimeMillis();
		logger.info("before: " +before);
		return true;
	}

}
