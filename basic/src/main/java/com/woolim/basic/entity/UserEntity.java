package com.woolim.basic.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name="user")
@Table(name="user")
public class UserEntity {
  @Id
  private String email;
  private String password;
  private String nickname;
  private String telNumber;
  private String address;
  private String addressDetail;
  private String profileImageUrl;
}
