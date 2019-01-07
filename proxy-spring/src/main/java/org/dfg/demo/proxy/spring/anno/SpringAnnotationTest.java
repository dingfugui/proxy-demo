package org.dfg.demo.proxy.spring.anno;

import org.dfg.demo.proxy.spring.FooService;
import org.dfg.demo.proxy.spring.IFooService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

/**
 * spring aop也是用代理模式实现，不能做到内部调用拦截
 * <p>
 * 所以内部调用不用this，而是getBean用获得的bean调用
 * <p>
 *
 * @author fugui.ding at 2018/12/13
 * @see org.springframework.context.annotation.AspectJAutoProxyRegistrar
 */
@Configuration
@ComponentScan("org.dfg.demo.proxy")
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class SpringAnnotationTest {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringAnnotationTest.class);

        final IFooService service = ctx.getBean(IFooService.class);
        service.foo();
    }

    @Bean
    public FooService fooService() {
        return new FooService();
    }
}
