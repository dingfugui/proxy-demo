package org.dfg.demo.proxy.aspectj.targetobj;

/**
 * @author fugui.ding at 2018/12/27
 */
public class TargetTest {
    public static void main(String[] args) {
        TargetService service = new TargetService();
        service.t1("a");
        service.t2(1);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        new TargetTest().run();
    }

    private void run() {
        TargetService service = new TargetService();
        service.t1("a");
        service.t2(1);
    }
}
