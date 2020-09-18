package com.gfa.iamgroot.models;

public class Arrow {
  private Float distance;
  private Float time;
  private float speed;

  public Arrow(float distance, float time) {
    this.distance=distance;
    this.time=time;
    speed=distance/time;
  }

  public float getTime() {
    return time;
  }

  public float getDistance() {
    return distance;
  }

  public void setDistance(Float distance) {
    this.distance = distance;
  }

  public float getSpeed() {
    return speed;
  }

  public void setSpeed(Float speed) {
    this.speed = speed;
  }
}
