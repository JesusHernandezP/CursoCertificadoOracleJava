package com.oracle.html5.demoframework;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named("editor")
public class DemoEditor implements Serializable {

  private Demo selected;

  public Demo getSelected() {
    return selected;
  }

  void setSelected(Demo demo) {
    selected = demo;
  }

}
