package org.spring.plane.service;

import org.spring.plane.domain.CustomUserDomain;

import java.util.List;

public interface CustomUserService {

    public void addCustomUser(CustomUserDomain customUserDomain);
    public void deleteCustomUser(long id);
    public CustomUserDomain findByLogin(String login);
    public void editCustomUser(CustomUserDomain customUserDomain);
    public List<CustomUserDomain> getUsers();
    public CustomUserDomain getUser(long id);
}
