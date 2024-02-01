package com.woolim.basic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// description: CORS policy - Cross Origin Resource Sharing 정책 //
// description: 웹 브라우저에서 접근하는 다른 출처의 리소스에서 우리 백엔드 리소스에 접근하지 못하도록 하는 정책 //
// description: Origin (출처) - 도메인, 프로토콜, 포트 //

// description: CORS 허용 - WebMvcConfigurer Spring 설정을 변경해야함 //
// description: @Configuration - Spring 설정 변경 어노테이션 //
@Configuration
public class CorsConfig implements WebMvcConfigurer {

  // description: WevMvcConfigurer 설정 중 addCorsMappins 메서드를 작성 //
  @Override
  public void addCorsMappings(CorsRegistry corsRegistry) {
    corsRegistry
      // description: mapping pattern 지정 //
      .addMapping("/**")
      // description: http method 지정 //
      .allowedMethods("*")
      // description: 출처 지정 //
      .allowedOrigins("*");
  }
  
}
