package org.newit.microservice.springMVCdemo;

import org.springframework.lang.Nullable;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2019-05-29.
 */
public class DemoIntercepter extends HandlerInterceptorAdapter{
    ThreadLocal<StopWatch> stopWatch = new ThreadLocal<StopWatch>();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       StopWatch stop = new StopWatch();
       stop.start();
       stopWatch.set(stop);
       return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        stopWatch.get().stop();
        System.out.println("user time:"+stopWatch.get().getTotalTimeMillis()+"ms");
        super.postHandle(request, response, handler, modelAndView);
    }
}
