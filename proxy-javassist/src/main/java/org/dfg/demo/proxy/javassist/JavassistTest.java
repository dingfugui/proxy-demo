package org.dfg.demo.proxy.javassist;

import javassist.*;
import org.dfg.demo.proxy.FooService;

import java.io.IOException;

/**
 * @author fugui.ding at 2018/12/24
 */
public class JavassistTest {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        //必须写字符串，不能写FooService.class.getName()，因为会触发类初始化，导致class被加载，执行toClass会报错
        CtClass cc = pool.get("org.dfg.demo.proxy.FooService");
        //cc.addInterface(pool.get(Serializable.class.getName()));

        final CtMethod method = cc.getDeclaredMethod("foo");
        method.insertBefore("System.out.println(\"before foo\");");
        method.setBody(method, null);

        cc.writeFile(Thread.currentThread().getContextClassLoader().getResource(".").getFile());
        cc.toClass();
        cc.freeze();

        FooService service = new FooService();
        service.foo();
    }
}
