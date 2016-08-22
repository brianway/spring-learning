package com.brianway.learning.spring.aop.instrument;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

/**
 * Created by brian on 16/8/22.
 */
public class Agent {
    public static void premain(String agentArgs, Instrumentation inst) {
        ClassFileTransformer transformer = new Transformer();
        inst.addTransformer(transformer);
    }
}

/*
根目录test

- 将 instrument 包下的 java 复制到 test 文件夹下的 com/instrument 包下
- 源码的 package 也改为 package com.instrument;
- 将 resources 下的 instrument 的 myManifest.mf 也复制到 test 下
- 修改为 `Premain-Class: com.instrument.Agent`
- 编译: `javac com/instrument/*`
- 创建 jar 包: `jar cvfm test.jar myManifest.mf ./ .`
- 启动: java -javaagent:test.jar com.instrument.Test

目录结构

# brian @ brianway in ~/tmp/test [11:17:48]
$ tree .
.
├── com
│   └── instrument
│       ├── Agent.class
│       ├── Agent.java
│       ├── Test.class
│       ├── Test.java
│       ├── Transformer.class
│       └── Transformer.java
└── myManifest.mf


-----------------输出-----------------------

# brian @ brianway in ~/tmp/test [10:47:24]
$ java -javaagent:test.jar com.instrument.Test
objc[5952]: Class JavaLaunchHelper is implemented in both /Library/Java/JavaVirtualMachines/jdk1.8.0_74.jdk/Contents/Home/bin/java and /Library/Java/JavaVirtualMachines/jdk1.8.0_74.jdk/Contents/Home/jre/lib/libinstrument.dylib. One of the two will be used. Which one is undefined.
Hello java/lang/invoke/MethodHandleImpl!
Hello java/lang/invoke/MethodHandleImpl$1!
Hello java/lang/invoke/MethodHandleImpl$2!
Hello java/util/function/Function!
Hello java/lang/invoke/MethodHandleImpl$3!
Hello java/lang/invoke/MethodHandleImpl$4!
Hello java/lang/ClassValue!
Hello java/lang/ClassValue$Entry!
Hello java/lang/ClassValue$Identity!
Hello java/lang/ClassValue$Version!
Hello java/lang/invoke/MemberName$Factory!
Hello java/lang/invoke/MethodHandleStatics!
Hello java/lang/invoke/MethodHandleStatics$1!
Hello sun/misc/PostVMInitHook!
Hello sun/usagetracker/UsageTrackerClient!
Hello java/util/concurrent/atomic/AtomicBoolean!
Hello sun/usagetracker/UsageTrackerClient$1!
Hello sun/usagetracker/UsageTrackerClient$4!
Hello sun/usagetracker/UsageTrackerClient$3!
Hello java/io/FileOutputStream$1!
Hello sun/launcher/LauncherHelper!
Hello java/util/concurrent/ConcurrentHashMap$ForwardingNode!
Hello com/instrument/Test!
Hello sun/launcher/LauncherHelper$FXHelper!
Hello java/lang/Class$MethodArray!
Hello java/lang/Void!
I'm in main() of Test ...
Hello java/lang/Shutdown!
Hello java/lang/Shutdown$Lock!
 */