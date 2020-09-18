package com.greenfoxacademy.frontend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Entry {
  private List<Log> entries;
  @JsonProperty("entry_count")
  private int numberOfCounts;

  public Entry(List<Log> entries) {
    this.entries=entries;
    numberOfCounts =entries.size();
  }

  public List<Log> getEntries() {
    return entries;
  }

  public void setEntries(List<Log> entries) {
    this.entries = entries;
  }

  public int getNumberOfCounts() {
    return numberOfCounts;
  }

  public void setNumberOfCounts(int numberOfCounts) {
    this.numberOfCounts = numberOfCounts;
  }
}
