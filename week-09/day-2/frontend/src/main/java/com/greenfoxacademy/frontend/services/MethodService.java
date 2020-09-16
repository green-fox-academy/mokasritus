package com.greenfoxacademy.frontend.services;

import com.greenfoxacademy.frontend.models.ArrayHandlerResultIsArray;
import com.greenfoxacademy.frontend.models.ArrayHandlerResultIsOneNumber;
import com.greenfoxacademy.frontend.models.DoUntil;
import com.greenfoxacademy.frontend.models.NumberForUntil;
import com.greenfoxacademy.frontend.models.ObjectFromJson;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MethodService {

  public Object showResult(ObjectFromJson objectFromJson) {
    if (objectFromJson.getWhat().equals("sum")) {
      return new ArrayHandlerResultIsOneNumber(sumArray(objectFromJson.getNumbers()));
    } else if (objectFromJson.getWhat().equals("multiply")) {
      return new ArrayHandlerResultIsOneNumber(multiplyArray(objectFromJson.getNumbers()));
    }else {
      return new ArrayHandlerResultIsArray(doubleNumbers(objectFromJson.getNumbers()));
    }
  }



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

  private int multiplyArray(int[] numbers) {
    int result = 1;
    for (int i = 0; i <= numbers.length - 1; i++) {
      result = result * numbers[i];
    }
    return result;
  }

  private int sumArray(int[] numbers) {
    int result = 0;
    for (int i = 0; i <= numbers.length-1; i++) {
      result = result + numbers[i];
    }
    return result;
  }

  private int[] doubleNumbers(int[] numbers) {
    int[] result = new int[numbers.length];
    for (int i = 0; i <= numbers.length-1; i++) {
      result[i]=numbers[i] * 2;
    }return result;
  }

}
