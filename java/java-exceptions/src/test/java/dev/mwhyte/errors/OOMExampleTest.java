package dev.mwhyte.errors;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OOMExampleTest {

  private OOMExample oomExample;

  @BeforeEach
  void setUp() {
    oomExample = new OOMExample();
  }

  @Test
  void addScore_smallNumbers() {
    for (int i = 0; i < 100; i++) {
      oomExample.addScore(i);
    }

    assertEquals(100, oomExample.getScores().size());
  }

  @Test
  void addScore_largeNumbers() {
    assertThrows(OutOfMemoryError.class, () -> {
      for (int i = 0; i < Integer.MAX_VALUE; i++) {
        oomExample.addScore(i);
      }
    });
  }
}