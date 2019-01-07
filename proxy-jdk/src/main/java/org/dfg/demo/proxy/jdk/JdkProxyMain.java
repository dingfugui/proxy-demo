package org.dfg.demo.proxy.jdk;

import org.dfg.demo.proxy.FooService;
import org.dfg.demo.proxy.IFooService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * jdk代理实现，实际上也是代理模式，内部调用无法被代理
 *
 * @author fugui.ding at 2018/12/13
 */
public class JdkProxyMain {

    public static void main(String[] args) {
        // JVM生成的Proxy类写入文件
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        FooService target = new FooService();
        InvocationHandler handler = (o, method, objects) -> {
            System.out.println("before:" + method.getName());
            return method.invoke(target, objects);
        };
        IFooService proxy = (IFooService) Proxy.newProxyInstance(JdkProxyMain.class.getClassLoader(), new Class[]{IFooService.class}, handler);
        proxy.foo();
    }

}
