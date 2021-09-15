package dev.mwhyte.errors;

import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SOExampleTest {

  private SOExample soExample;

  @BeforeEach
  void setUp() {
    soExample = new SOExample();
  }

  @Test
  void countdown_smallNumbersAreFine() {
    soExample.countdown(100);
  }

  @Test
  void countdown_largeNumbersThrowSOE() {
    assertThrows(StackOverflowError.class, () -> soExample.countdown(10000000));
  }
}