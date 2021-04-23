package com.vitaliy.paymentapp.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j

public class LoggingInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       String sessionId =  RequestContextHolder.currentRequestAttributes().getSessionId();
      log.info("User session id is :" + sessionId);
        return true;
    }
}
