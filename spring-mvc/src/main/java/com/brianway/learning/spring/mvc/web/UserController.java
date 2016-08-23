package com.brianway.learning.spring.mvc.web;

import com.brianway.learning.spring.mvc.UserService;
import com.brianway.learning.spring.mvc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * Created by brian on 16/8/22.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public ModelAndView createUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user/createSuccess");
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping(value = "/register")
    public String register(@ModelAttribute("user") User user) {
        System.out.println(user);
        return "user/register";
    }

    @RequestMapping(value = "/toString")
    public String printRequestBody(@RequestBody String requestBody) {
        System.out.println(requestBody);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/images/{imageId}")
    public byte[] showImage(@PathVariable("imageId") String imageId) throws IOException {
        System.out.println("load image of " + imageId);
        Resource resource = new ClassPathResource("/images/hearthstone.png");
        byte[] fileOut = FileCopyUtils.copyToByteArray(resource.getInputStream());
        return fileOut;
    }

    @RequestMapping(value = "/httpEntity")
    public String printHttpEntity(HttpEntity<String> httpEntity) throws IOException {
        long contentLength = httpEntity.getHeaders().getContentLength();
        System.out.println(contentLength);
        System.out.println(httpEntity.getBody());
        return "success";
    }

    @RequestMapping(value = "/httpEntity/{imageId}")
    public ResponseEntity<byte[]> showEntity(@PathVariable("imageId") String imageId) throws IOException {
        Resource resource = new ClassPathResource("/images/hearthstone.png");
        byte[] fileOut = FileCopyUtils.copyToByteArray(resource.getInputStream());
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(fileOut, HttpStatus.OK);
        responseEntity.getHeaders().setContentType(MediaType.parseMediaType(IMAGE_PNG_VALUE));
        return responseEntity;
    }

}
