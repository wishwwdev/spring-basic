package com.woolim.basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.woolim.basic.filter.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
// description: @EnableWibSecurity - 보안 관련 필터 설정을 할 수 있도록 하는 어노테이션 //
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

  private final JwtAuthenticationFilter jwtAuthenticationFilter;

  // description: Security Filter 설정 변경 //
  @SuppressWarnings("removal")
  @Bean
  protected SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {

    httpSecurity
      // description: cors 정책 설정 - 기본 설정으로 사용 //
      .cors(cors ->cors.configure(httpSecurity))
      // description: csrf 보안 설정 - 미사용 //
      .csrf(crsf ->crsf.disable())
      // description: basic authentication 설정 - 미사용 //
      .httpBasic(basic ->basic.disable())
      // description: session 정책 설정 //
      .sessionManagement(management ->management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
      // description: API의 URL 패턴에 따라 인증 여부 지정 //
      .authorizeHttpRequests()
      // description: 특정 패턴에 대하여 인증 없이 진행 가능하도록 허용 //
      .requestMatchers("/", "/auth/match").permitAll()
      // description: 특정 메서드에 대하여 인증 없이 진행 가능하도록 허용 //
      .requestMatchers(HttpMethod.GET).permitAll()
      // description: 특정 메서드에 해당하는 특정 패턴에 대하여 인증없이 진행 가능하도록 허용 //
      .requestMatchers(HttpMethod.POST, "/sign-in", "/sign-up").permitAll()
      // description: 나머지 요청에 대하여 인증을 필수로 진행하도록 설정 //
      .anyRequest().authenticated();

    // description: jwtAuthenticationFilter를 httpSecurity 필터에 추가 //
    httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    return httpSecurity.build();
  }
  
}
