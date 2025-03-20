package com.sitepark.ies.shared.security.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AccessDeniedExceptionTest {
  @Test
  void testConstructor() {
    AccessDeniedException exception = new AccessDeniedException("Test");
    assertEquals("Test", exception.getMessage(), "Wrong message");
  }
}
