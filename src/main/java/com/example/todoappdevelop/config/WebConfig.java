package com.example.todoappdevelop.config;

import com.example.todoappdevelop.filter.LoginFilter;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.config
 * <li>fileName       : WebConfig
 * <li>author         : daca0
 * <li>date           : 24. 11. 14.
 * <li>description    : 필터 등록을 위한 클래스
 * </ul>
 * ===========================================================
 * <p>
 * 24. 11. 14.        daca0       최초 생성
 * </p>
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 로그인 필터 등록
     *
     * @return 첫번째 필터
     */
    @Bean
    public FilterRegistrationBean loginFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LoginFilter());
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;
    }

}
