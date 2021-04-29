package org.spring.plane.service;

import org.spring.plane.dao.CustomUserRepository;
import org.spring.plane.dao.UserRoleRepository;
import org.spring.plane.domain.CustomUserDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomUserServiceImpl implements CustomUserService {

    private final CustomUserRepository customUserRepository;
    private final UserRoleRepository userRoleRepository;

    @Autowired
    public CustomUserServiceImpl(CustomUserRepository customUserRepository, UserRoleRepository userRoleRepository) {
        this.customUserRepository = customUserRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void addCustomUser(CustomUserDomain customUserDomain) {
        customUserDomain.setEnabled(true);
        customUserDomain.getUserRoles().add(userRoleRepository.findByRole("ROLE_USER"));
        customUserDomain.setPassword(hashPassword(customUserDomain.getPassword()));
        this.customUserRepository.save(customUserDomain);
    }

    @Override
    public void deleteCustomUser(long id) {
        this.customUserRepository.delete(id);
    }

    @Override
    public CustomUserDomain findByLogin(String login) {
        return this.customUserRepository.findByLogin(login);
    }

    @Override
    public void editCustomUser(CustomUserDomain customUserDomain) {
//        customUserDomain.setTickets(this.customUserRepository.findByLogin(customUserDomain.getLogin()).getTickets());
//        customUserDomain.setEnabled(true);
        this.customUserRepository.save(customUserDomain);
    }

    @Override
    public List<CustomUserDomain> getUsers() {
        return this.customUserRepository.findAll();
    }

    @Override
    public CustomUserDomain getUser(long id) {
        return this.customUserRepository.getOne(id);
    }

    private String hashPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }
}
