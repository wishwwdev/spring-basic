package com.woolim.basic.service.implement;

import org.springframework.stereotype.Service;

import com.woolim.basic.service.MainService;

// description: 레이어드 아키텍처 상의 비즈니스 영역 //
// description: 실제 비즈니스 로직(연산, 유효성 검사)이 작성되는 구역 //

// description: @Service -  해당 클래스가 Service 영역임을 명시 //
// description: @Component를 포함하고 있어서 Spring Bean으로 등록할 수 있음 //
// description: Spring Bean으로 등록해야 Spring에게 IoC 할 수 있음 //
@Service
public class MainServiceImplement implements MainService {

  @Override
  public String hello() {
    return "hello world";
  }
  
}
