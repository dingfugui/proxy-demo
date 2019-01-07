package org.dfg.demo.proxy.aspectj.impl;

/**
 * @author fugui.ding at 2018/12/27
 */
public class UserServiceTest {

    private IUserService service;

    public UserServiceTest(UserService userService) {
        this.service = userService;
    }

    public static void main(String[] args) {
        new UserServiceTest(new UserService()).run();
    }

    public void run() {
        service.f2();
    }

}
