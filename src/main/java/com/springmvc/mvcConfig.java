package com.springmvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration //It tells Spring that this class contains bean definitions for the application context.
@EnableWebMvc
@ComponentScan({"com.springmvc"}) //pakage name
public class mvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.APPLICATION_JSON);
    }

    /*This method converter,
   creates a new instance of MappingJackson2HttpMessageConverter.
    This is a Jackson 2-based HttpMessageConverter. It is used to convert
    Java objects to/from JSON and is able to handle most Java types.
     It is also set to return the JSON in a "pretty" format, which means it will
     be more human-readable.*/
    @Bean
    public MappingJackson2HttpMessageConverter converter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setPrettyPrint(true);
        return converter;
    }


/*The third method, configureMessageConverters, is used to configure
 the message converters. It adds the MappingJackson2HttpMessageConverter
 created in the previous method to the list of converters,
 which means it will be used to handle the conversion between Java objects and JSON.*/
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converter());
    }
}
