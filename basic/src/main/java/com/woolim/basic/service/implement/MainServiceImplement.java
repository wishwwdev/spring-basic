package com.woolim.basic.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.woolim.basic.entity.UserEntity;
import com.woolim.basic.repository.UserRepository;
import com.woolim.basic.service.MainService;

import lombok.RequiredArgsConstructor;

// description: 레이어드 아키텍처 상의 비즈니스 영역 //
// description: 실제 비즈니스 로직(연산, 유효성 검사)이 작성되는 구역 //

// description: @Service -  해당 클래스가 Service 영역임을 명시 //
// description: @Component를 포함하고 있어서 Spring Bean으로 등록할 수 있음 //
// description: Spring Bean으로 등록해야 Spring에게 IoC 할 수 있음 //
@Service
@RequiredArgsConstructor
public class MainServiceImplement implements MainService {

  private final UserRepository userRepository;

  @Override
  public String hello() {
    UserEntity userEntity = new UserEntity("email@email.com", "111111", "hong", "01022222222", "서울", "부산진구", null);
    userRepository.save(userEntity);
    return "hello world";
  }

  @Override
  public String getRepository() {
    List<UserEntity> userEntity = userRepository.findByNickname("hong");
    return userEntity.toString();
  }
}