package org.dfg.demo.proxy.spring.xml;

import org.dfg.demo.proxy.spring.IFooService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author fugui.ding at 2018/12/28
 * @see org.springframework.beans.factory.xml.DefaultNamespaceHandlerResolver
 * @see org.springframework.beans.factory.xml.BeanDefinitionParserDelegate
 * @see org.springframework.aop.config.AopNamespaceHandler
 * @see org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator
 * @see org.springframework.aop.framework.DefaultAopProxyFactory
 */
public class SpringXmlTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        final IFooService service = ctx.getBean(IFooService.class);
        service.foo();
    }
}
