package com.ebay.manager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.List;

@EnableWebMvc
@Configuration
public class WebMvcConfigurerAdapter implements WebMvcConfigurer {

    /**
     * 返回中文不乱码
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(stringHttpMessageConverterForUtf8());
        converters.add(new MappingJackson2HttpMessageConverter());
    }


    @Bean
    public StringHttpMessageConverter stringHttpMessageConverterForUtf8() {
        return new StringHttpMessageConverter(StandardCharsets.UTF_8);
    }
}