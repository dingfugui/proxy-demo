package org.dfg.demo.proxy.spring.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author fugui.ding at 2018/12/13
 */
@Aspect
@Component
public class SpringAspect {

    @Pointcut("execution(* *..FooService.*(..))")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void advice(JoinPoint point) {
        System.out.println("spring before:" + point.getSignature().getName());
    }

}
