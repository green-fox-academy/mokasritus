package com.greenfoxacademy.frontend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "logs")
public class Log {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String endpoint;
  private String data;

  @JsonIgnore
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;


  public Log() {
    createdAt=new Date();
  }

  public Log(String endpoint, String data) {
    this();
    this.endpoint = endpoint;
    this.data = data;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public String getEndpoint() {
    return endpoint;
  }

  public void setEndpoint(String endpoint) {
    this.endpoint = endpoint;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
