package pl.arkadiusz.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.arkadiusz.dao.UserRepository;
import pl.arkadiusz.domain.UserDomain;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDomain getUserById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<UserDomain> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.delete(id);
    }

    @Override
    public void editUser(UserDomain user) {
        userRepository.save(user);
    }

    @Override
    public void addUser(UserDomain user) {
        userRepository.save(user);
    }
}
