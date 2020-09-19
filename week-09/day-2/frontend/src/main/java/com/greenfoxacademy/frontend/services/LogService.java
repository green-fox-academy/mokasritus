package com.greenfoxacademy.frontend.services;

import com.greenfoxacademy.frontend.models.Log;
import java.util.List;

public interface LogService {

  public void save(Log log);

  public List<Log> showAllLog();
}
