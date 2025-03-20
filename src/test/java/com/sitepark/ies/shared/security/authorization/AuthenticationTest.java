package com.sitepark.ies.shared.security.authorization;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class AuthenticationTest {
  @Test
  void testHasPermissionWithFullAccess() {
    Authentication authentication = spy();
    when(authentication.getPermissions()).thenReturn(List.of(new FullAccess()));

    assertTrue(authentication.hasPermission(Permission.class));
  }

  @Test
  void testHasPermissionFound() {
    Authentication authentication = spy();
    when(authentication.getPermissions()).thenReturn(List.of(new PermissionA())).getMock();

    assertTrue(authentication.hasPermission(PermissionA.class));
  }

  @Test
  void testHasPermissionNotFound() {
    Authentication authentication = spy();

    Permission permissionA = new PermissionA();
    Permission permissionB = new PermissionB();

    when(authentication.getPermissions()).thenReturn(List.of(permissionA));

    assertFalse(authentication.hasPermission(permissionB.getClass()));
  }

  @Test
  void testGetPermissionByTypeFound() {
    Authentication authentication = spy();

    Permission permissionA = new PermissionA();
    Permission permissionB = new PermissionB();

    when(authentication.getPermissions()).thenReturn(List.of(permissionA, permissionB));

    assertEquals(
        Optional.of(permissionA),
        authentication.getPermission(permissionA.getClass()),
        "Wrong permission");
  }

  @Test
  void testGetPermissionByTypeNotFound() {
    Authentication authentication = spy();

    Permission permissionA = new PermissionA();
    Permission permissionB = new PermissionB();

    when(authentication.getPermissions()).thenReturn(List.of(permissionB));

    assertEquals(
        Optional.empty(), authentication.getPermission(permissionA.getClass()), "Should be empty");
  }

  @Test
  void testGetPermissionsByType() {
    Authentication authentication = spy();

    Permission permissionA = new PermissionA();
    Permission permissionB = new PermissionB();

    when(authentication.getPermissions()).thenReturn(List.of(permissionA, permissionB));

    assertEquals(
        List.of(permissionA),
        authentication.getPermissions(permissionA.getClass()),
        "Wrong permission");
  }

  private static class PermissionA implements Permission {
    @Override
    public String getType() {
      return "A";
    }
  }

  private static class PermissionB implements Permission {
    @Override
    public String getType() {
      return "B";
    }
  }
}
