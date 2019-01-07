package org.dfg.demo.proxy.staticproxy;

import org.dfg.demo.proxy.FooService;
import org.dfg.demo.proxy.IFooService;

/**
 * 代理模式
 *
 * @author fugui.ding at 2018/12/18
 */
public class FooServiceProxy implements IFooService {

    private IFooService fooService;

    public FooServiceProxy() {
        this.fooService = new FooService();
    }

    @Override
    public void foo() {
        System.out.println("before foo");
        fooService.foo();
    }

    public static void main(String[] args) {
        new FooServiceProxy().foo();
    }
}
