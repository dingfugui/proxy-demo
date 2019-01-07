package org.dfg.demo.proxy.spring;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

/**
 * @author fugui.ding at 2018/12/13
 */
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class FooService implements IFooService {

    @Autowired
    ApplicationContext ctx;

    public FooService() {
    }

    public void foo() {
        System.out.println("foo");
        bar();

        System.out.println("~~~~~~~~~");
        Object proxy = AopContext.currentProxy();
        if (proxy instanceof FooService) {
            ((FooService) proxy).bar();
        }

        System.out.println("~~~~~~~~~");
        ctx.getBean(FooService.class).bar();
    }

    public void bar() {
        System.out.println("bar");
    }

    public void foo3() {
        System.out.println("foo3");
        foo4();
    }

    public void foo4() {
        System.out.println("foo4");
    }
}
