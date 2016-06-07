package com.brianway.learning.spring.ioc.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Brian on 2016/5/12.
 */

/**
 * org.springframework.core.io包
 * FileSystemResource
 * ClassPathResource
 */
public class FileSourceExample {
    public static void main(String[] args) {
        try {
            String filePath = "/Users/brian/mygit/spring-learning/spring-ioc/src/main/java/com/brianway/learning/spring/ioc/resource/FileSourceExample.java";

            //使用系统文件路径加载方式
            Resource resource1 = new FileSystemResource(filePath);

            //使用类路径加载文件
            Resource resource2 = new ClassPathResource("example/file1.txt");

            InputStream is1 = resource1.getInputStream();
            InputStream is2 = resource2.getInputStream();

            System.out.println("res1:"+resource1.getFilename());
            System.out.println("res2:"+resource2.getFilename());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
