package org.dfg.demo.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.dfg.demo.proxy.FooService;

import java.lang.reflect.Method;

/**
 * java -classpath "%JAVA_HOME%/lib/sa-jdi.jar" sun.jvm.hotspot.HSDB
 *
 * @author fugui.ding at 2018/12/13
 */
public class CglibInnerCallTest {
    public static void main(String[] args) {
        FooService target = new FooService();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(FooService.class);
        enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) -> {
            System.out.println("before:" + method.getName());
            return proxy.invoke(target, args1);
        });
        FooService service = (FooService) enhancer.create();
        service.foo();

        System.out.println("~~~~~~~");

        enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) -> {
            System.out.println("before:" + method.getName());
            return proxy.invokeSuper(obj, args1);
        });
        service = (FooService) enhancer.create();
        service.foo();
    }
}