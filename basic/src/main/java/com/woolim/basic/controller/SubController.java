package com.woolim.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// description: httpL//localhost:8080/sub //
@RequestMapping("/sub")
public class SubController {
  
  @GetMapping("/")
  public String getMethod() {
    return "sub get method";
  }

}
