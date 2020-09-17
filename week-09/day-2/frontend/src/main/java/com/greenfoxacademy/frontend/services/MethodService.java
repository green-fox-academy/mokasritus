package com.greenfoxacademy.frontend.services;

import com.greenfoxacademy.frontend.models.Log;
import com.greenfoxacademy.frontend.models.arrayhandler.ArrayHandlerResultIsArray;
import com.greenfoxacademy.frontend.models.arrayhandler.ArrayHandlerResultIsOneNumber;
import com.greenfoxacademy.frontend.models.arrayhandler.ObjectFromJson;
import com.greenfoxacademy.frontend.models.checkonwebsite.DoUntil;
import com.greenfoxacademy.frontend.models.checkonwebsite.NumberForUntil;
import com.greenfoxacademy.frontend.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface MethodService {

  public Object showResult(ObjectFromJson objectFromJson);

  public DoUntil getResultValue(String action, NumberForUntil numberForUntil);

}
