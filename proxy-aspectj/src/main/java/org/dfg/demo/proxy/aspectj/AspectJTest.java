package org.dfg.demo.proxy.aspectj;

import org.dfg.demo.proxy.FooService;

/**
 * 用ajc编译，可以不用加启动参数：静态织入
 * 不用ajc编译，必须加-javaagent:E:\aspectjweaver-1.9.2.jar：动态织入，类加载的时候修改
 *
 * @author fugui.ding at 2017/1/11
 */
public class AspectJTest {
    public static void main(String[] args) {
        new FooService().foo();
    }
}
