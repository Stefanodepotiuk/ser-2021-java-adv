package ua.com.owu.ser2021javaadv.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String path = "File:///" + System.getProperty("user.home") + File.separator + "avatars" + File.separator;

        registry.addResourceHandler("/user/avatar/**")
                .addResourceLocations(path);
    }
}
