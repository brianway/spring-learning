package com.brianway.learning.spring.ioc.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

/**
 * Created by Brian on 2016/5/12.
 *
 * EncodedResource
 */
public class FileSourceExample2 {
    public static void main(String[] args) throws Throwable {
        Resource res = new ClassPathResource("example/file1.txt");
        EncodedResource encodedRes = new EncodedResource(res, "UTF-8");
        String content = FileCopyUtils.copyToString(encodedRes.getReader());
        System.out.println(content);
    }
}
