package org.dfg.demo.proxy.aspectj;

import org.dfg.demo.proxy.FooService;

/**
 *
 * @author fugui.ding at 2018/12/20
 */
public aspect AspectJFieldModify {
/*    private long FooService.start;

    public long FooService.getStart() {
        return this.start;
    }

    public void FooService.setStart(long start) {
        this.start = start;
    }

    pointcut changes(FooService s): target(s) && call(void FooService.foo());

    before(FooService s): changes(s) {
        s.setStart(System.currentTimeMillis());
    }

    after(FooService s): changes(s) {
        System.out.println("foo用时:" + (System.currentTimeMillis() - s.getStart()));
    }*/
}