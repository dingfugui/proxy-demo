package org.dfg.demo.proxy.aspectj.agentmain;

import com.sun.tools.attach.VirtualMachine;
import org.aspectj.weaver.loadtime.Agent;
import org.dfg.demo.proxy.FooService;

import java.lang.management.ManagementFactory;

/**
 * @author fugui.ding at 2018/12/24
 */
public class AspectJRetransformTest {
    public static void main(String[] args) throws Exception {
        FooService.class.getName();

        String pid = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
        final VirtualMachine machine = VirtualMachine.attach(pid);
        machine.loadAgent("E:\\aspectjweaver-1.9.2.jar");
        machine.detach();

        Agent.getInstrumentation().retransformClasses(FooService.class);

        new FooService().foo();
    }
}
