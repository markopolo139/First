package dev.mk.First.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class ThyMeLeafConfiguration {

    @Bean
    @Scope("singleton")
    public ITemplateResolver getTemplateResolver() {
        ClassLoaderTemplateResolver classLoaderTemplateResolver = new ClassLoaderTemplateResolver();
        classLoaderTemplateResolver.setTemplateMode(TemplateMode.HTML);
        classLoaderTemplateResolver.setPrefix("/templates/");
        classLoaderTemplateResolver.setSuffix(".html");
        classLoaderTemplateResolver.setCharacterEncoding("UTF-8");
        return classLoaderTemplateResolver;
    }

    @Bean
    @Scope("singleton")
    public ITemplateEngine getTemplateEngine() {
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(getTemplateResolver());
        templateEngine.addDialect(new Java8TimeDialect());
        
        return templateEngine;
    }
}
