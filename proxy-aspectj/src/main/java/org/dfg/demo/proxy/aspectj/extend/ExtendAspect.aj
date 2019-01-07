package org.dfg.demo.proxy.aspectj.extend;

/**
 *
 * @author fugui.ding at 2018/12/26
 */
public aspect ExtendAspect {

    pointcut callAny(): call(* *..extend.pojo.*.*(..));
    pointcut execAny(): execution(* *..extend.pojo.*.*(..));

    //pointcut pc(): callAny(); //ParentTest、ChildTest调用处被拦截，call无法捕获非静态方法的super
    //pointcut pc(): execAny(); //父子类方法都会织入

    //this: when the object currently executing (i.e. this) is of type SomeType
    //target: when the target object is of type SomeType
    //pointcut pc(): this(Child); //none
    //pointcut pc(): target(Parent); //none
    //pointcut pc(): this(ChildTest); //拦截到ChildTest所有方法调用，包括属性（child、out）、内部方法call和execution，外部方法的call（println）
    //pointcut pc(): this(ParentTest); //同上
    //pointcut pc(): target(ChildTest); //拦截到ChildTest所有方法调用，包括属性，不包括对其他对象方法的调用
    //pointcut pc(): target(ParentTest); //同上
    /*
        this：拦截到所有的“.”，即对象的属性访问和方法调用，也包括对其他对象的访问，拦截不到main方法里的调用
        target：拦截到指定类的切面，包括call和execute、对象的属性访问，可以拦截静态方法，所以输出两次run，拦截不到对其他对象方法的调用
        都是在指定类内部织入
     */

    //pointcut pc(): execAny() && target(Child); //none
    //pointcut pc(): execAny() && this(Child); //none
    //pointcut pc(): execAny() && target(Parent); //none
    //pointcut pc(): execAny() && this(Parent); //none
    //pointcut pc(): callAny() && target(Child); //none
    //pointcut pc(): callAny() && this(Child); //none
    //pointcut pc(): callAny() && target(Parent); //none
    //pointcut pc(): callAny() && this(Parent); //none
    /* Child、Parent方法内没有调用 */

    //pointcut pc(): execAny() && target(ParentTest); //none
    //pointcut pc(): callAny() && target(ParentTest); //none
    //pointcut pc(): execAny() && this(ParentTest); //none
    //pointcut pc(): callAny() && this(ParentTest); //ParentTest调用处被拦截
    //pointcut pc(): execAny() && target(ChildTest); //none
    //pointcut pc(): callAny() && target(ChildTest); //none
    //pointcut pc(): execAny() && this(ChildTest); //none
    //pointcut pc(): callAny() && this(ChildTest); //ChildTest调用处被拦截
    //只有this能拦截到对其他对象的call


    //when the executing code belongs to class MyClass
    //within表示调用点所在的类
    //pointcut pc(): within(Parent); //none
    pointcut pc(): within(Child);//none
    //pointcut pc(): within(ParentTest);//拦截了ParentTest的所有方法
    //pointcut pc(): within(ChildTest);//拦截了ChildTest的所有方法，包括main方法，对其他类属性的访问，对其他类方法的调用
    //可以拦截到ChildTest的out.println，却拦截不到Child的out.println

    //pointcut pc(): callAny() && within(Parent); //none
    //pointcut pc(): execAny() && within(Parent);//none
    //pointcut pc(): callAny() && within(Child);//none
    //pointcut pc(): execAny() && within(Child);//none
    //全部拦截不到，因为调用点在Test类里

    //pointcut pc(): callAny() && within(ParentTest); //拦截到了parent的方法
    //pointcut pc(): execAny() && within(ParentTest);//none
    //pointcut pc(): callAny() && within(ChildTest);//拦截到了Child所有方法
    //pointcut pc(): execAny() && within(ChildTest);//none
    //2、4没有拦截到，因为test类里只有调用其他类的call切入点

    before (): pc() {
        System.out.println("aspect before:" + thisJoinPoint.getSignature().getName() + ",kind:" + thisJoinPoint.getKind());
    }

}
