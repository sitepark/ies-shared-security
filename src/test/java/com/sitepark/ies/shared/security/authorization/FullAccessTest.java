package com.sitepark.ies.shared.security.authorization;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FullAccessTest {
  @Test
  void testGetType() {
    FullAccess fullAccess = new FullAccess();
    assertEquals("FULL_ACCESS", fullAccess.getType(), "Wrong type");
  }
}
