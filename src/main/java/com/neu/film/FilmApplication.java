package com.neu.film;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

//如果需要使用 Mapper 注解  这里需要扫描
@MapperScan("com.neu.film.mapper")
@SpringBootApplication
public class FilmApplication {
    private CorsConfiguration buildConfig(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //允许任何域名使用
        corsConfiguration.addAllowedOrigin("*");
        //允许任何头
        corsConfiguration.addAllowedHeader("*");
        //允许任何方法(post、get)
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }
    /*
        跨域过滤器
        org.springframework.web.cors.UrlBasedCorsConfigurationSource;
        org.springframework.web.filter.CorsFilter;
     */
    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",buildConfig());
        return new CorsFilter(source);
    }
    public static void main(String[] args) {
        SpringApplication.run(FilmApplication.class, args);
    }

}
