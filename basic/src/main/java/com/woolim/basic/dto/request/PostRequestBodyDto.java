package com.woolim.basic.dto.request;

public class PostRequestBodyDto {
  private String name;
  private int age;

  public PostRequestBodyDto () {}

  public void setAge(int age) {
    this.age = age;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public String getName() {
    return name;
  }
  
}
