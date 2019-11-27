package com.train.web.Config;


import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class MVCInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?> []{};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // 指定Web配置類
        return new Class<?>[] {WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        // 將 DispatcherServlet 對映到 "/" 路徑
        return new String[] { "/" };
    }

    @Override
    protected Filter[] getServletFilters() {
        final CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceRequestEncoding(true);
        return new Filter[] { encodingFilter };
    }
}
