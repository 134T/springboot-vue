package com.baizhi.places_vue.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.swing.*;

/**
 * @Description:
 * @Author: 坚持的力量
 * @Date: 2021/10/11 12:18
 * @Version: 11
 */
@Configuration
public class DateConverterBean {
    @Resource
    private RequestMappingHandlerAdapter handlerAdapter;

    @PostConstruct
    public void inittttt(){
        ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer) handlerAdapter.getWebBindingInitializer();
        GenericConversionService conversionService = (GenericConversionService) initializer.getConversionService();
        conversionService.addConverter(new DateConverterConfig());
    }
}
