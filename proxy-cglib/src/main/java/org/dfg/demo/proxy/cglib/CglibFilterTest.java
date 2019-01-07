package org.dfg.demo.proxy.cglib;

import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.dfg.demo.proxy.FooService;

import java.lang.reflect.Method;

/**
 * @author fugui.ding at 2018/12/19
 */
public class CglibFilterTest {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(FooService.class);
        enhancer.setCallbacks(new MethodInterceptor[]{fooInterceptor, defaultInterceptor});
        enhancer.setCallbackFilter(method -> {
            if ("foo".equals(method.getName())) {
                return 0;
            } else {
                return 1;
            }
        });
        FooService service = (FooService) enhancer.create();
        service.foo();
        service.bar();
    }

    private static MethodInterceptor fooInterceptor = (obj, method, args, proxy) -> {
        System.out.println("invoke foo");
        return proxy.invokeSuper(obj, args);
    };

    private static MethodInterceptor defaultInterceptor = (obj, method, args, proxy) -> {
        System.out.println("invoke other");
        return proxy.invokeSuper(obj, args);
    };
}