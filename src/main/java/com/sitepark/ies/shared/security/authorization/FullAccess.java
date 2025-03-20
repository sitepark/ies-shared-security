package com.sitepark.ies.shared.security.authorization;

public class FullAccess implements Permission {
  public static final String TYPE = "FULL_ACCESS";

  @Override
  public String getType() {
    return TYPE;
  }
}
