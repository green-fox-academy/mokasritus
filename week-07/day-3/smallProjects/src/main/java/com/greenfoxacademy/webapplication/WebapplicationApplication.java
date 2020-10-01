package com.greenfoxacademy.webapplication;

import com.greenfoxacademy.webapplication.coloring.MyColor;
import com.greenfoxacademy.webapplication.coloring.RedColor;
import com.greenfoxacademy.webapplication.hellodiproject.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebapplicationApplication implements CommandLineRunner{

  private Printer printer;
  private MyColor myColor;

  @Autowired
  public WebapplicationApplication(Printer printer, MyColor mycolor) {
    this.printer = printer;
    this.myColor=mycolor;
  }

  public static void main(String[] args) {
    SpringApplication.run(WebapplicationApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    printer.log("hello");
    myColor.printColor();
  }
}
