package cn.bsnmdpf.fcprt.headquarters9001.config;

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
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/payPage").setViewName("payPage");
        registry.addViewController("/welcome").setViewName("welcome");
    }

}
