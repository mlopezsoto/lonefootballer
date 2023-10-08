package com.mls.lonefootballer.user;

import java.util.List;

public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserRecord> findAllUsers() {
        return userRepository.findBy();
    }
}
