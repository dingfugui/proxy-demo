package org.dfg.demo.agentmain;

import com.sun.tools.attach.VirtualMachine;
import javassist.ClassPool;
import javassist.CtClass;

import java.io.File;
import java.lang.instrument.ClassDefinition;
import java.lang.management.ManagementFactory;

/**
 * @author fugui.ding at 2018/12/26
 */
public class RedefineTest {
    public static void main(String[] args) throws Exception {
        FooService.class.getName();

        final File file = new File("./agentmain/target/agentmain-1.0-SNAPSHOT.jar");

        String pid = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
        final VirtualMachine machine = VirtualMachine.attach(pid);
        machine.loadAgent(file.getCanonicalPath());
        machine.detach();

        SimpleAgent.instrumentation.redefineClasses(new ClassDefinition(FooService.class, getByteArray()));

        new FooService().foo();
    }

    /**
     * redefine用法很灵活
     * 可以传入修改过的字节码，ClassFileTransformer里直接返回
     * 也可以传入原始字节码，ClassFileTransformer里修改
     * 两边需要对应，否则会出现重复修改
     *
     * @return
     * @throws Exception
     */
    public static byte[] getByteArray() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get(FooService.class.getName());
        return cc.toBytecode();
    }
}
