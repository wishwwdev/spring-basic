package com.woolim.basic.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.woolim.basic.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
  List<UserEntity> findByNickname(String nickname);
}
