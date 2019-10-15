package gar.iso.core.service;

import gar.iso.core.model.User;

public interface UserService {
    User findById(final Integer id);
}
