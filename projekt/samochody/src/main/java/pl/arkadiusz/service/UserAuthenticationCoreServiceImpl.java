package pl.arkadiusz.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.arkadiusz.dao.UserAuthenticationCoreRepository;
import pl.arkadiusz.domain.UserAuthenticationCoreDomain;

import java.util.List;

@Service
@Transactional
public class UserAuthenticationCoreServiceImpl implements UserAuthenticationCoreService {
    UserAuthenticationCoreRepository repository;

    public UserAuthenticationCoreServiceImpl(UserAuthenticationCoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addUserCore(UserAuthenticationCoreDomain userCore) {
        userCore.setPassword(hashPassword(userCore.getPassword()));
        repository.save(userCore);
    }

    @Override
    public void deleteUserCoreById(Long id) {
        repository.delete(id);
    }

    @Override
    public UserAuthenticationCoreDomain getUserById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public UserAuthenticationCoreDomain getUserByEmail(String email) {
        return repository.findFirstByEmail(email);
    }

    @Override
    public List<UserAuthenticationCoreDomain> getUsers() {
        return repository.findAll();
    }

    @Override
    public void editUserCore(UserAuthenticationCoreDomain user) {
        repository.save(user);
    }

    private String hashPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }
}
