package org.dfg.demo.proxy.staticproxy;

import org.dfg.demo.proxy.FooService;

/**
 * @author fugui.ding at 2018/12/13
 */
public class FooServiceProxy2 extends FooService {

    @Override
    public void foo() {
        System.out.println("before foo");
        super.foo();
    }

    public static void main(String[] args) {
        new FooServiceProxy2().foo();
    }
}
