package com.woolim.basic.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostRequestBodyDto {
  @NotBlank
  private String name;
  @NotNull
  private Integer age;
}
