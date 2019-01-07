package org.dfg.demo.agentmain;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author fugui.ding at 2018/12/26
 */
public class TestJavassist {

    public static void main(String[] args) throws IOException, NotFoundException {
        ClassPool pool = ClassPool.getDefault();

        final InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("org/dfg/demo/agentmmain/FooService.class");
        final CtClass cc = pool.makeClass(is);

        for (CtMethod method : cc.getMethods()) {
            System.out.println(method.getName());
        }

        System.out.println(cc.getMethod("foo", "()V"));
    }

}
