package org.dfg.demo.proxy.spring;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author fugui.ding at 2018/12/19
 */
public class ProxyFactoryTest {
    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory();
        factory.setProxyTargetClass(true);
        factory.setTarget(new FooService());
        factory.addAdvice((MethodBeforeAdvice) (method, args1, target) -> System.out.println("before:" + method.getName()));
        final FooService proxy = (FooService) factory.getProxy();
        proxy.foo();
    }
}
