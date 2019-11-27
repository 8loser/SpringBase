package com.train.web.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
@EnableWebMvc
@ComponentScan("com.train.web")
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private ApplicationContext applicationContext;

    /*
     * STEP 1 - Create SpringResourceTemplateResolver
     */
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        // 模板檔案前綴名稱(檔案路徑)
        templateResolver.setPrefix("/WEB-INF/Views/");
        // 模板檔案後綴名稱(副檔名)
        templateResolver.setSuffix(".html");
        // 模板檔案編碼
        templateResolver.setCharacterEncoding("UTF-8");
        // 停用快取，修改模板檔案不用重啟tomcat
        templateResolver.setCacheable(false);
        templateResolver.setTemplateMode(TemplateMode.HTML);
        return templateResolver;
    }

    /*
     * STEP 2 - Create SpringTemplateEngine
     */
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    /*
     * STEP 3 - Register ThymeleafViewResolver
     */
    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        // 模板回覆內容編碼
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setTemplateEngine(templateEngine());
        return viewResolver;
    }

    /**
     * 新增靜態資源檔
     * @param registry
     */
    /*
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 註冊靜態資源檔 JS, CSS
        registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/static/");
        registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/");
        registry.addResourceHandler("/plugins/**").addResourceLocations("/WEB-INF/plugins/");
    }
    */


    /**
     * 新增攔截器
     */
    /*
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor());
    }
     */
}
