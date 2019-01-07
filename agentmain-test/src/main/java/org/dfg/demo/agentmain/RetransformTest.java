package org.dfg.demo.agentmain;

import com.sun.tools.attach.VirtualMachine;

import java.io.File;
import java.lang.management.ManagementFactory;

/**
 * @author fugui.ding at 2018/12/26
 */
public class RetransformTest {
    public static void main(String[] args) throws Exception {
        FooService.class.getName();

        final File file = new File("./agentmain/target/agentmain-1.0-SNAPSHOT.jar");

        String pid = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
        final VirtualMachine machine = VirtualMachine.attach(pid);
        machine.loadAgent(file.getCanonicalPath());
        machine.detach();

        SimpleAgent.instrumentation.retransformClasses(FooService.class);

        new FooService().foo();
    }

}
