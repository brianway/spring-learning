package com.brianway.learning.spring.ioc.resource;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * Created by Brian on 2016/5/12.
 */
public class PatternResolverTest {

    public static void main(String[] args) throws Throwable{
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resources[] = resolver.getResources("classpath*:example/**/*.xml");
        for (Resource resource:resources){
            //System.out.println(resource.getDescription());
            System.out.println(resource.getFilename());
        }
    }
}
