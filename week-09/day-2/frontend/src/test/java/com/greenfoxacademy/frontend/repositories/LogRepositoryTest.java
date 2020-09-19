package com.greenfoxacademy.frontend.repositories;

import com.greenfoxacademy.frontend.models.Log;
import java.util.ArrayList;
import java.util.List;

public class LogRepositoryTest {
  private List<Log> logs;

  public LogRepositoryTest() {
    this.logs = new ArrayList<>();
  }


  public void save(Log log) {
    logs.add(log);
  }

  public List<Log> getLogs() {
    return logs;
  }
}
