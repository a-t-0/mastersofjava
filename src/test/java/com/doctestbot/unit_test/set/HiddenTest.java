package com.doctestbot.unit_test.set;

import org.junit.jupiter.api.Test;

public class HiddenTest {

  @Test
  public void play() {
    SetTest tester = new SetTest();
    for (int i = 0; i < 10; i++) {
      tester.play();
    }
  }
}
