package webapp.bankapp.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/add_user").setViewName("add_user");
        registry.addViewController("/transaction").setViewName("transaction");
        registry.addViewController("/constatnt_transacions").setViewName("constatnt_transacions");
        registry.addViewController("/history").setViewName("add_user");
    }

}

