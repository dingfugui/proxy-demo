package org.dfg.demo.agentmain;

import java.lang.instrument.Instrumentation;

/**
 * @author fugui.ding at 2018/12/26
 */
public class SimpleAgent {

    public static Instrumentation instrumentation;

    public static void agentmain(final String options, final Instrumentation instrumentation) {
        System.out.println("agentmain! arg:" + options);
        instrumentation.addTransformer(new SimpleTransformer());//第二个参数只影响retransform

        SimpleAgent.instrumentation = instrumentation;
    }

}
