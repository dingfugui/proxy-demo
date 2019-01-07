package org.dfg.demo.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.dfg.demo.proxy.FooService;

import java.lang.reflect.Method;

/**
 * 1.8
 * java -classpath "%JAVA_HOME%/lib/sa-jdi.jar" sun.jvm.hotspot.HSDB
 * 9+
 * %JAVA_HOME%/bin/jhsdb hsdb
 *
 * @author fugui.ding at 2018/12/13
 */
public class CglibTest {
    public static void main(String[] args) {
        FooService target = new FooService();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(FooService.class);
        enhancer.setCallback(new Interceptor(target));
        FooService service = (FooService) enhancer.create();
        service.foo();
    }
}

class Interceptor implements MethodInterceptor {

    private FooService target;

    public Interceptor(FooService target) {
        this.target = target;
    }

    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("before:" + method.getName());
        return proxy.invokeSuper(obj, args);
        //return proxy.invoke(target, args);
        //return proxy.invoke(obj, args); //StackOverflowError
        //return proxy.invokeSuper(target, args); //ClassCastException
    }

}