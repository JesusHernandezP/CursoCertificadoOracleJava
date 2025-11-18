package com.oracle.html5.demoframework;

import java.util.List;

public abstract class DemoIterator {

  private final List<Demo> demos;

  public DemoIterator(List<Demo> demos) {
    this.demos = demos;
  }

  public abstract void each(Demo demo);

  public void iterate() {
    iterate(demos);
  }

  private void iterate(List<Demo> demos) {
    for (Demo demo : demos) {
      each(demo);
      iterate(demo.getDemos());
    }
  }
}
