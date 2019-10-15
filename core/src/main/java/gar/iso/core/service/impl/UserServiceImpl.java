package gar.iso.core.service.impl;

import gar.iso.core.exception.ListException;
import gar.iso.core.model.User;
import gar.iso.core.repository.UserRepository;
import gar.iso.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Integer id) {
        Optional<User> result = userRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        // TODO: 10/15/2019 add message
        throw new ListException();
    }
}
