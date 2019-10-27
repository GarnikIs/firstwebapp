package gar.iso.core.service;

import gar.iso.core.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO findById(final Long id);

    UserDTO create(final UserDTO user);

    UserDTO findByEmail(final String email);

    boolean emailExists(final String email);

    List<UserDTO> findAll();
}
