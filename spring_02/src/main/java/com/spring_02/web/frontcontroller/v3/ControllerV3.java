package com.spring_02.web.frontcontroller.v3;

import com.spring_02.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {
  ModelView process(Map<String, String> paramMap);
}
