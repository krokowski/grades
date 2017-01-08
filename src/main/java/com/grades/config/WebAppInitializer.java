package com.grades.config;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by Sylwia on 2017-01-08.
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { MvcConfig.class };
    }
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
