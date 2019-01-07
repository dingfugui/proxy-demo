package org.dfg.demo.proxy.aspectj.extend;

import org.dfg.demo.proxy.aspectj.extend.pojo.Child;

/**
 * @author fugui.ding at 2018/12/27
 */
public class ChildTest {

    private Child child;

    public ChildTest(Child child) {
        this.child = child;
    }

    public static void main(String[] args) {
        new ChildTest(new Child()).run();
    }

    public void run() {
        child.p1();
        System.out.println("~~~~~~");
        child.p2();
        System.out.println("~~~~~~");
        child.c1();
    }

}
