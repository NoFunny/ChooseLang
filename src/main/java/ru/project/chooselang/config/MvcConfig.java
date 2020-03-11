package ru.project.chooselang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * This class needed to set up the default mvc login page.
 * @author NoFunny
 * @version 1.0
 * @see WebMvcConfigurer
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     *
     * @param registry
     */

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("login");
    }

}