package com.brianway.learning.spring.mvc.web;

import org.junit.Assert;
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

    @Test
    public void testFormat() {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
        form.add("userId", "0001");
        form.add("userName", "Tom");
        form.add("password", "123");
        form.add("birthday", "1992-11-25");
        form.add("salary", "4,500.00");
        String html = restTemplate.postForObject(URL_PREFIX + "format", form, String.class);
        Assert.assertNotNull(html);
        Assert.assertTrue(html.contains("Tom"));
        System.out.println(html);
    }

    @Test
    public void testValidateSuccess() {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
        form.add("userId", "0001");
        form.add("userName", "Tony");
        form.add("password", "123");
        form.add("birthday", "1992-11-25");
        form.add("salary", "4,500.00");
        String html = restTemplate.postForObject(URL_PREFIX + "validate", form, String.class);
        Assert.assertNotNull(html);
        Assert.assertFalse(html.contains("user.errors"));
        System.out.println(html);
    }

    @Test
    public void testValidateError() {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
        form.add("userId", "0001");
        form.add("userName", "No");
        form.add("password", "123");
        form.add("birthday", "2992-11-25");
        form.add("salary", "900.00");
        String html = restTemplate.postForObject(URL_PREFIX + "validate", form, String.class);
        Assert.assertNotNull(html);
        Assert.assertTrue(html.contains("user.errors"));
        System.out.println(html);
    }

    @Test
    public void testUserValidator() {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
        form.add("userId", "0001");
        form.add("userName", "aaaa");
        form.add("password", "123");
        form.add("birthday", "1992-11-25");
        form.add("salary", "4,500.00");
        String html = restTemplate.postForObject(URL_PREFIX + "validate", form, String.class);
        Assert.assertNotNull(html);
        Assert.assertTrue(html.contains("user.errors"));
        System.out.println(html);
    }

    @Test
    public void testUserListMix() {
        String url = URL_PREFIX + "userListMix";
        RestTemplate restTemplate = new RestTemplate();

        //默认使用jsp
        String responseJsp = restTemplate.getForObject(url, String.class);
        Assert.assertNotNull(responseJsp);
        System.out.println(responseJsp);

        //根据请求参数"format"
        String responseJson = restTemplate.getForObject(url + "?format=json", String.class);
        Assert.assertNotNull(responseJson);
        System.out.println(responseJson);

        //根据文件拓展名
        String responseXml = restTemplate.getForObject(url + ".xml", String.class);
        Assert.assertNotNull(responseXml);
        System.out.println(responseXml);
    }

    @Test
    public void testLocaleResolver() {
        String url = URL_PREFIX + "validate";
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();

        String responseCN = restTemplate.postForObject(url + "?locale=zh_CN", form, String.class);
        Assert.assertNotNull(responseCN);
        System.out.println(responseCN);

        String responseUS = restTemplate.postForObject(url + "?locale=en_US", form, String.class);
        Assert.assertNotNull(responseUS);
        System.out.println(responseUS);
    }

}
