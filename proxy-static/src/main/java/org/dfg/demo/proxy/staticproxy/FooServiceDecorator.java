package org.dfg.demo.proxy.staticproxy;

import org.dfg.demo.proxy.FooService;
import org.dfg.demo.proxy.IFooService;

/**
 * 装饰者模式
 *
 * @author fugui.ding at 2018/12/18
 */
public class FooServiceDecorator implements IFooService {

    private IFooService fooService;

    public FooServiceDecorator(IFooService fooService) {
        this.fooService = fooService;
    }

    @Override
    public void foo() {
        System.out.println("before foo");
        fooService.foo();
    }

    public static void main(String[] args) {
        new FooServiceDecorator(new FooService()).foo();
    }
}
