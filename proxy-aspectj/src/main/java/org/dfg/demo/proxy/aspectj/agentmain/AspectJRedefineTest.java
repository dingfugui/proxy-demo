package org.dfg.demo.proxy.aspectj.agentmain;

import com.sun.tools.attach.VirtualMachine;
import org.apache.commons.io.IOUtils;
import org.aspectj.weaver.loadtime.Agent;
import org.dfg.demo.proxy.FooService;

import java.io.InputStream;
import java.lang.instrument.ClassDefinition;
import java.lang.management.ManagementFactory;

/**
 * @author fugui.ding at 2018/12/24
 */
public class AspectJRedefineTest {
    public static void main(String[] args) throws Exception {
        FooService.class.getName();//触发类加载

        String pid = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
        final VirtualMachine machine = VirtualMachine.attach(pid);
        machine.loadAgent("E:\\aspectjweaver-1.9.2.jar");
        //machine.loadAgentLibrary("instrument", "E:\\aspectjweaver-1.9.2.jar");
        machine.detach();

        final InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("org/dfg/demo/proxy/FooService.class");
        Agent.getInstrumentation().redefineClasses(new ClassDefinition(FooService.class, IOUtils.toByteArray(is)));

        new FooService().foo();
    }
}
