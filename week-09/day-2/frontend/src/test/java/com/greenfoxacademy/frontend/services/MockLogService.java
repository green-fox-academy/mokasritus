package com.greenfoxacademy.frontend.services;

import com.greenfoxacademy.frontend.models.Log;
import com.greenfoxacademy.frontend.repositories.LogRepositoryTest;
import java.util.List;

public class MockLogService implements LogService {
  private LogRepositoryTest logRepositorytest;

  @Override
  public void save(Log log) {
    logRepositorytest.save(log);
  }

  @Override
  public List<Log> showAllLog() {
    return logRepositorytest.getLogs();
  }
}
