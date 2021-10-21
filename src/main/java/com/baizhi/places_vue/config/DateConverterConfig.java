package com.baizhi.places_vue.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: 坚持的力量
 * @Date: 2021/10/11 11:48
 * @Version: 11
 */

@Component
public class DateConverterConfig implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = null;
        try {
            date = dateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
