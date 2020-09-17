package com.greenfoxacademy.frontend.services;

import com.greenfoxacademy.frontend.models.arrayhandler.ObjectFromJson;
import com.greenfoxacademy.frontend.models.checkonwebsite.DoUntil;
import com.greenfoxacademy.frontend.models.checkonwebsite.NumberForUntil;

public class MockMethodService implements MethodService{
  @Override
  public Object showResult(ObjectFromJson objectFromJson) {
    return null;
  }

  @Override
  public DoUntil getResultValue(String action, NumberForUntil numberForUntil) {
    return null;
  }
}
