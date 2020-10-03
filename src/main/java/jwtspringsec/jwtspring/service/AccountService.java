package jwtspringsec.jwtspring.service;

import jwtspringsec.jwtspring.entities.AppRole;
import jwtspringsec.jwtspring.entities.AppUser;

public interface AccountService {
    public AppUser saveUser(AppUser user);
    public AppRole saveRole(AppRole appRole);
    public void addRoleToUser(String username,String roleName);
    public AppUser findUserByUsername(String username);
}
