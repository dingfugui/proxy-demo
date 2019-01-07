package org.dfg.demo.proxy.aspectj.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author fugui.ding at 2018/12/27
 */
@Aspect
public class ImplAdvisorClass {

    //@Before("call(* *..UserService.*(..))")
    public void advice(JoinPoint joinPoint) {
        System.out.println("aspect before:" + joinPoint.getSignature().getName());
    }

}
