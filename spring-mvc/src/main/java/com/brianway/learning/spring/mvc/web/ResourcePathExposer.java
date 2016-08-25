package com.brianway.learning.spring.mvc.web;

import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

public class ResourcePathExposer implements ServletContextAware {
    private ServletContext servletContext;
    private String resourceRoot;

    public void init() {
        String version = "1.2.1";
        resourceRoot = "/resources-" + version;
        getServletContext().setAttribute("resourceRoot",
                getServletContext().getContextPath() + resourceRoot);
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public String getResourceRoot() {
        return resourceRoot;
    }

    public ServletContext getServletContext() {
        return servletContext;
    }
}
