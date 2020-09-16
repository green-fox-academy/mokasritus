package com.greenfoxacademy.frontend.services;

import com.greenfoxacademy.frontend.models.DoUntil;
import com.greenfoxacademy.frontend.models.NumberForUntil;
import org.springframework.stereotype.Service;

@Service
public class MethodService {

  public DoUntil getResultValue(String action, NumberForUntil numberForUntil) {
    if (action.equals("sum")) {
      return new DoUntil(sum(numberForUntil));
    }
   // if (action.equals("factor")) {
      return new DoUntil(factor(numberForUntil));
    }
 // }

  private int sum(NumberForUntil numberForUntil) {
    int result = 0;
    for (int i = 1; i <= numberForUntil.getUntil(); i++) {
      result += i;
    }
    return result;
  }

  private int factor(NumberForUntil numberForUntil) {
    int result = 1;
    for (int i = 1; i <= numberForUntil.getUntil(); i++) {
      result = result * i;
    }
    return result;
  }
}
