package com.example.schedulerapp.config;

import com.example.schedulerapp.filter.CustomFilter;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //Spring 설정 클래스임을 나태내는 어노테이션 (implements WebMvcConfigurer를 구현하면 Spring MVC의 설정을 커마할 수 있지만 지금은 FilterRegistrationBean을 활용한 필터 등록만 담당)
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public FilterRegistrationBean customFilter() {

        //FilterRegistrationBean<Filter>을 사용하여 CustomFilter를 등록
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();

        //FilterRegistrationBean<Filter>을 사용하여 CustomFilter 등록
        filterRegistrationBean.setFilter(new CustomFilter());

        //이 필터의 실행 순서를 1순위로 지정
        filterRegistrationBean.setOrder(1);

        //모든 요청(/*)에 대해 필터를 적용
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean loginFilter() {

        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();

    }
}
