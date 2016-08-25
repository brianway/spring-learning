package com.brianway.learning.spring.mvc.web;

import com.brianway.learning.spring.mvc.domain.User;
import com.brianway.learning.spring.mvc.domain.UserEditor;
import com.brianway.learning.spring.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by brian on 16/8/22.
 */
@Controller
@RequestMapping("/user")
@SessionAttributes("userSession")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/success")
    public String success() {
        return "success";
    }

    @RequestMapping(value = "/fail")
    public String fail() {
        return "fail";
    }

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
        return responseEntity;
    }

    @RequestMapping(value = "/setId")
    public String setId(@ModelAttribute("user") User user) {
        user.setUserId("1000");
        return "user/createSuccess";
    }

    /**
     * 访问UserController任何一个请求处理方法前,
     * Spring MVC 先执行该方法,并将返回值以 user 为键添加到模型中
     */
    @ModelAttribute("user")
    public User getUser() {
        User user = new User();
        user.setUserId("1001");
        user.setUserName("Brian");
        return user;
    }

    @RequestMapping(value = "/show")
    public String show(ModelMap modelMap) {
        modelMap.addAttribute("testAttr", "testValue");
        User user = (User) modelMap.get("user");
        user.setUserName("Way");
        return "/user/showUser";
    }

    @RequestMapping(value = "/showRedirect")
    public String showRedirect(@ModelAttribute("userSession") User user) {
        user.setUserName("Netty");
        return "redirect:/user/showSession";
    }

    @RequestMapping(value = "/showSession")
    public String showSession(ModelMap modelMap, SessionStatus sessionStatus) {
        User user = (User) modelMap.get("userSession");
        if (user != null) {
            user.setUserId("2001");
            sessionStatus.setComplete();
        } else {
            System.out.println("null userSession");
        }
        return "/user/showUser";
    }

    @ModelAttribute("userSession")
    public User getUserSession() {
        User user = new User();
        user.setUserId("2000");
        user.setUserName("Apple");
        return user;
    }

    @RequestMapping(value = "convert")
    public String convert(@RequestParam("user") User user, ModelMap modelMap) {
        modelMap.put("user", user);
        return "/user/showUser";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(User.class, new UserEditor());
        binder.addValidators(new UserValidator());
    }

    @RequestMapping(value = "/format")
    public String format(User user) {
        return "/user/showUser";
    }

    @RequestMapping(value = "/validate")
    public String validate(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/user/registerValidator";
        } else {
            return "/user/showUser";
        }
    }

    @RequestMapping("/userValidator")
    public String userValidator(@ModelAttribute("user") User user, BindingResult bindingResult) {
        ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "userName", "required");
        if ("aaaa".equalsIgnoreCase(user.getUserName())) {
            bindingResult.rejectValue("userName", "reserved");
        }
        if (bindingResult.hasErrors()) {
            return "/user/registerUserValidator";
        } else {
            return "/user/showUser";
        }
    }

    @RequestMapping("/userList")
    public String ShowUserList(ModelMap modelMap) {
        List<User> users = userService.getUsers();
        modelMap.addAttribute("userList", users);
        return "user/userList";
    }

    @RequestMapping("/userListByFtl")
    public String ShowUserListInFtl(ModelMap modelMap) {
        List<User> users = userService.getUsers();
        modelMap.addAttribute("userList", users);
        return "userListFtl";
    }

    @RequestMapping("/userListByXls")
    public String ShowUserListInExcel(ModelMap modelMap) {
        List<User> users = userService.getUsers();
        modelMap.addAttribute("userList", users);
        return "userListExcel";
    }

    @RequestMapping("/userListByPdf")
    public String ShowUserListInPdf(ModelMap modelMap) {
        List<User> users = userService.getUsers();
        modelMap.addAttribute("userList", users);
        return "userListPdf";
    }

    @RequestMapping("/userListByJson")
    public String ShowUserListInJson(ModelMap modelMap) {
        List<User> users = userService.getUsers();
        modelMap.addAttribute("userList", users);
        return "userListJson";
    }

    @RequestMapping("/userListByXml")
    public String ShowUserListInXml(ModelMap modelMap) {
        List<User> users = userService.getUsers();
        modelMap.addAttribute("userList", users);
        return "userListXml";
    }

    @RequestMapping("/userListMix")
    public String ShowUserListMix(ModelMap modelMap) {
        List<User> users = userService.getUsers();
        modelMap.addAttribute("userList", users);
        return "userListMix";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload() {
        return "uploadPage";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) throws Exception {
        if (!file.isEmpty()) {
            String pathname = "/Users/brian/todo/tmp/" + file.getOriginalFilename();
            file.transferTo(new File(pathname));
            return "redirect:success";
        } else {
            return "redirect:fail";
        }
    }

    @RequestMapping("/resource")
    public String resource() {
        return "testResource";
    }

    @RequestMapping(value = "/error")
    public String error() {
        return "error";
    }

    @RequestMapping("/throwException")
    public String throwException() {
        throw new RuntimeException("Throw a exception on purpose");
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleException(RuntimeException re, HttpServletRequest request) {
        return "forward:/user/error";
    }

}
