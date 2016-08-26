# Spring learning note(spring 学习笔记)

本项目对 spring 的实现机制通过例子进行展示和剖析,并附上部分源码的分析说明。

更详细的工程实用例子可以参考我的另一个仓库 [springmvc-mybatis-learning](https://github.com/brianway/springmvc-mybatis-learning)

**如果觉得不错，请先在这个仓库上点个 star 吧**，这也是对我的肯定和鼓励，谢谢了。

不定时进行调整和补充，需要关注更新的请 Watch、Star、Fork


-----

## 仓库目录

- [spring-helloworld](/spring-helloworld):一个简单的用户登录小例子,涉及 mvc 和 数据库读写
- [spring-ioc](/spring-ioc):一些 ioc 的小例子,涉及生命周期,注入,bean 的配置等等
- [spring-aop](/spring-aop):一些 aop 的小例子,涉及各种切点知识,动态代理(JDK,CGLib),`@AspectJ`, LTW等等
- [spring-mvc](/spring-nvc):一些 mvc 的小例子,涉及注解驱动控制器,数据绑定,视图和视图解析器,本地化解析,上传文件,静态资源处理等


-----	


## 安装和使用

环境准备:

- jdk 1.8+
- intellij IDEA 15.0.2+
- mysql 5.1+
- maven 3.3+
- tomcat 8+


数据库导入:

- [spring-helloworld](/spring-helloworld) 模块中默认的数据库名为 `sampledb`
- 导入 [spring-helloworld/src/main/resources](/spring-helloworld/src/main/resources/) 中的 [helloword.sql](/spring-helloworld/src/main/resources/helloworld.sql) 添加数据表和测试数据


在 IDE 中添加 tomcat 容器:

- ToolBar -> 运行按钮旁边的下拉 -> "Edit Configurations" -> "+" -> "Tomcat Server" 选 local,[如图所示](http://7xph6d.com1.z0.glb.clouddn.com/IDEA_web-%E6%B7%BB%E5%8A%A0tomcat-01.png)
- 如果是第一次添加,还需要配置 tomcat 的路径,[如图所示](http://7xph6d.com1.z0.glb.clouddn.com/IDEA_web-%E6%B7%BB%E5%8A%A0tomcat-02.png)
- [spring-helloworld](/spring-helloworld) 和 [spring-mvc](/spring-nvc) 模块各自需要添加一个 tomcat 容器


## TODO

计划逐步完善这个仓库，扩充并实现下面的功能。

* [x] 入门小例子，spring-helloworld
* [x] IoC
* [x] AOP
* [x] spring MVC
* [ ] 整理部分源码分析,形成博客

	

-----

# 联系作者

- [Brian's Personal Website](http://brianway.github.io/)
- [CSDN](http://blog.csdn.net/h3243212/)
- [oschina](http://my.oschina.net/brianway)


-----

# Lisence

Lisenced under [Apache 2.0 lisence](http://opensource.org/licenses/Apache-2.0)
