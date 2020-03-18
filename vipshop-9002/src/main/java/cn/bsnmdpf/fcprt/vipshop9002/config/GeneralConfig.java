package cn.bsnmdpf.fcprt.vipshop9002.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author LicoLeung
 * @create 2020-02-02 13:34
 */
@Configuration
public class GeneralConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("payInfoInputPage");
    }

}
