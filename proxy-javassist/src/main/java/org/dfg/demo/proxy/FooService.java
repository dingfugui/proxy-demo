package org.dfg.demo.proxy;

/**
 * @author fugui.ding at 2018/12/13
 */
public class FooService {

    public void foo() {
        System.out.println("foo");
        bar();
    }

    public void bar() {
        System.out.println("bar");
    }

}
