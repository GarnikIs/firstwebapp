package gar.iso.core.service.impl;

import gar.iso.core.config.BeanMapper;
import gar.iso.core.dto.UserDTO;
import gar.iso.core.exception.ListException;
import gar.iso.core.model.User;
import gar.iso.core.repository.UserRepository;
import gar.iso.core.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private final UserRepository userRepository;
    private final BeanMapper beanMapper;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository, final BeanMapper beanMapper) {
        this.userRepository = userRepository;
        this.beanMapper = beanMapper;
    }

    @Override
    public UserDTO findById(final Long id) {
        Optional<User> result = userRepository.findById(id);
        if (result.isPresent()) {
            return beanMapper.map(result.get(), UserDTO.class);
        }
        // TODO: 10/15/2019 add message
        throw new ListException();
    }

    @Override
    public UserDTO create(final UserDTO user) {
        LOGGER.debug("Creating user for given user {}.", user);

        final User userToCreate = beanMapper.map(user, User.class);
        final User cratedUser = userRepository.saveAndFlush(userToCreate);

        LOGGER.debug("Creating user done for given user {}.", user);
        return beanMapper.map(cratedUser, UserDTO.class);
    }

    @Override
    public UserDTO findByEmail(final String email) {
        LOGGER.debug("Getting user by given email {}.", email);
        User result = userRepository.findByEmail(email);
        if (result == null){
            // TODO: 10/27/2019
            throw new ListException();
        }
        LOGGER.debug("Done getting user by given email {}.", email);
        return beanMapper.map(result, UserDTO.class);
    }

    @Override
    public boolean emailExists(final String email) {
        return false;
    }

    @Override
    public List<UserDTO> findAll() {
        return null;
    }
}
