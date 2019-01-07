package org.dfg.demo.proxy.aspectj.impl;

/**
 *
 * @author fugui.ding at 2018/12/27
 */
public aspect ImplAdvisor {

    //pointcut pc(): call(* *..IUserService.*(..));
    //pointcut pc(): execution(* *..IUserService.*(..));

    pointcut pc(): call(* *..UserService.*(..)); //由于多态性，编译时取不到实际类型，所以f2方法拦截不到
    //pointcut pc(): execution(* *..UserService.*(..));

    before (): pc() {
        System.out.println("aspect before:" + thisJoinPoint.getSignature().getName());
    }

}
