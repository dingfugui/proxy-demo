package org.dfg.demo.proxy.aspectj.extend;

import org.dfg.demo.proxy.aspectj.extend.pojo.Child;
import org.dfg.demo.proxy.aspectj.extend.pojo.Parent;

/**
 * @author fugui.ding at 2018/12/26
 */
public class ParentTest {

    private Parent parent;

    public ParentTest(Parent parent) {
        this.parent = parent;
    }

    public static void main(String[] args) {
        new ParentTest(new Child()).run();
    }

    public void run() {
        parent.p1();
        System.out.println("~~~~~~");
        parent.p2();
    }

}
