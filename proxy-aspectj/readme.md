ajc 编译时织入
```
ajc -cp E:\\aspectjrt-1.9.2.jar -d target\ajc src\main\java\org\dfg\demo\proxy\FooService.java src\main\java\org\dfg\demo\proxy\aspectj\AspectAdvice.aj src\main\java\org\dfg\demo\proxy\aspectj\AspectJTest.java
```

ajc 编译后织入
```
ajc -cp E:\aspectjrt-1.9.2.jar -inpath target\classes\ -d target\ajc src\main\java\org\dfg\demo\proxy\aspectj\AspectAdvice.aj
ajc -cp E:\aspectjrt-1.9.2.jar -inpath target\proxy-aspectj-1.0-SNAPSHOT.jar -outjar target\weaver.jar src\main\java\org\dfg\demo\proxy\asp
ectj\AspectAdvice.aj
```

运行时织入
```
java -javaagent:E:\aspectjweaver-1.9.2.jar -cp E:\aspectjrt-1.9.2.jar;target\classes\ org.dfg.demo.proxy.aspectj.AspectJTest
```