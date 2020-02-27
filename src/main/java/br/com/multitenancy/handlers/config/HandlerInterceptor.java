package br.com.multitenancy.handlers.config;

import br.com.multitenancy.core.CurrentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandlerInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private CurrentContext currentContext;

    private Logger logger = LoggerFactory.getLogger(HandlerInterceptor.class);
    private static final String HEADER = "TENANT";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String tenantId = request.getHeader(HEADER);
        currentContext.setTenantName(tenantId);
        logger.info("Handle message from tenant: ".concat(tenantId));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        logger.info("Message sucessfull");
    }
}
