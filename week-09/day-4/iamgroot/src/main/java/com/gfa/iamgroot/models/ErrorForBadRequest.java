package com.gfa.iamgroot.models;

public class ErrorForBadRequest {
  private String error;

  public ErrorForBadRequest(String errorMessage) {
    error=errorMessage;
     }

  public void setError(String error) {
    this.error = error;
  }

  public String getError() {
    return error;
  }
}
