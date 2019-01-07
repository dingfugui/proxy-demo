package org.dfg.demo.proxy.aspectj.targetobj;

/**
 *
 * @author fugui.ding at 2018/12/27
 */
public aspect TargetAdvisor {

    pointcut execAny(): execution(* *..targetobj.TargetService.*(..));
    pointcut callAny(): call(* *..targetobj.TargetService.*(..));

    //pointcut pc2(): target(TargetService); //拦截所有对TargetService的方法的call（在调用方）和execution（在内部）
    //pointcut pc2(): this(TargetService); //拦截所有对TargetService内部的属性访问，方法调用call、execution.

    //pointcut pc2(Object o): target(o) && callAny(); //target=TargetService,拦截到了对TargetService的所有方法的call
    pointcut pc2(Object o): this(o) && callAny(); //虚方法（run）调用处拦截call，因为this拦截不到main

    //pointcut pc2(Object o): target(o) && execAny(); //TargetService方法内编织
    //pointcut pc2(Object o): this(o) && execAny(); //同上

    //不管是target还是this，target对象永远是切点所在类

    before(Object o): pc2(o) {
        System.out.println("aspect: " + thisJoinPoint.getSignature().getName() + "," + "target:" + thisJoinPoint.getTarget());
    }

}
