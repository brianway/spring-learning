package com.brianway.learning.spring.aop.advisor;

import com.brianway.learning.spring.aop.introduce.Monitorable;
import org.springframework.aop.support.IntroductionInfoSupport;

public class MyIntroduceInfo extends IntroductionInfoSupport {
    public MyIntroduceInfo() {
        super();
        super.publishedInterfaces.add(Monitorable.class);
    }
}
