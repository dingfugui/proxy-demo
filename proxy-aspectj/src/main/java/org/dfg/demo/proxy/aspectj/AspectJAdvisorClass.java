package org.dfg.demo.proxy.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author fugui.ding at 2018/12/18
 */
@Aspect
public class AspectJAdvisorClass {

    @Pointcut("execution(* *..FooService.*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void pointcut(JoinPoint joinPoint) {
        System.out.println("aspect before:" + joinPoint.getSignature().getName());
    }

}
