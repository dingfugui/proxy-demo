package org.dfg.demo.proxy.aspectj.impl;

/**
 * @author fugui.ding at 2018/12/27
 */
public class UserService implements IUserService {

    @Override
    public void f1() {
        System.out.println("f1");
    }

    @Override
    public void f2() {
        System.out.println("f2");
        f1();
    }

}
