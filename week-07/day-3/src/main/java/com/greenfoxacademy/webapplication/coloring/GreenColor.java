package com.greenfoxacademy.webapplication.coloring;

import com.greenfoxacademy.webapplication.hellodiproject.Printer;
import org.springframework.stereotype.Service;

@Service
public class GreenColor implements MyColor {
  private Printer printer;

  public GreenColor(Printer printer) {
    this.printer = printer;
  }

  @Override
  public void printColor() {
    printer.log("It is green in color...");
  }
}
