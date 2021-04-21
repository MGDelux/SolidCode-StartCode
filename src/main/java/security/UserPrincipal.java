package security;

import entities.DummyEntity1;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserPrincipal implements Principal {

  private String username;
  private List<String> roles = new ArrayList<>();

  /* Create a UserPrincipal, given the Entity class DummyEntity1*/
  public UserPrincipal(DummyEntity1 user) {
    this.username = user.getUserName();
    this.roles = user.getRolesAsStrings();
  }

  public UserPrincipal(String username, String[] roles) {
    super();
    this.username = username;
    this.roles = Arrays.asList(roles);
  }

  @Override
  public String getName() {
    return username;
  }

  public boolean isUserInRole(String role) {
    return this.roles.contains(role);
  }
}