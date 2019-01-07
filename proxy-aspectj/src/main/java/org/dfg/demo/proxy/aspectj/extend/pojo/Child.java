package org.dfg.demo.proxy.aspectj.extend.pojo;

/**
 * @author fugui.ding at 2018/12/26
 */
public class Child extends Parent {

    public void p1() {
        super.p1();
    }

    public void c1() {
        System.out.println("child c1()");
    }

    public static void main(String[] args) {
        new Child().c1();
    }

}
