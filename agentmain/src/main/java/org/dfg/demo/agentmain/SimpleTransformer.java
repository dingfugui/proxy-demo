package org.dfg.demo.agentmain;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.io.ByteArrayInputStream;
import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

/**
 * @author fugui.ding at 2018/12/26
 */
public class SimpleTransformer implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> type, ProtectionDomain domain, byte[] bytes) {
        if (!"org/dfg/demo/agentmain/FooService".equals(className)) {
            return null;
        }
        System.out.println("transform!");

        try {
            ClassPool pool = new ClassPool();
            pool.appendSystemPath();
            CtClass cc = pool.makeClass(new ByteArrayInputStream(bytes));
            final CtMethod method = cc.getMethod("foo", "()V");
            method.insertBefore("System.out.println(\"before foo\");");
            return cc.toBytecode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
