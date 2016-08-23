package com.brianway.learning.spring.mvc.web;

import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Created by brian on 16/8/23.
 */
public class UserControllerTest {

    private static final String URL_PREFIX = "http://localhost:8080/user/";

    @Test
    public void testPrintRequestBody() {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
        form.add("userName", "Tom");
        form.add("password", "123");
        restTemplate.postForLocation(URL_PREFIX + "toString", form);
    }

    @Test
    public void testShowImage() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        byte[] reponse = restTemplate.postForObject(URL_PREFIX + "images/{itemId}", null, byte[].class, "1");
        Resource outFile = new FileSystemResource("/Users/brian/todo/tmp/test.jpg");
        FileCopyUtils.copy(reponse, outFile.getFile());
    }
}
