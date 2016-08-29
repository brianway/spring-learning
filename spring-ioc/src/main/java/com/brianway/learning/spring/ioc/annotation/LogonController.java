package com.brianway.learning.spring.ioc.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LogonController {

    @Autowired
    private LogonService logonService;

    public void invokeInitMethod() {
        logonService.initMethod();
    }
}
