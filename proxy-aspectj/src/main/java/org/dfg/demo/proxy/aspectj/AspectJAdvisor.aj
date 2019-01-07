package org.dfg.demo.proxy.aspectj;

/**
 * javac编译不了，LTW识别不了aj文件
 * @author fugui.ding at 2018/12/18
 */
public aspect AspectJAdvisor {

    //when a particular method body executes
    //pointcut pc(): (execution(* *..FooService.*(..)));

    //when a method is called
    pointcut pc(): (call(* *..FooService.*(..)));

    before (): pc() {
        System.out.println("aspect before:" + thisJoinPoint.getSignature().getName());
    }

}
