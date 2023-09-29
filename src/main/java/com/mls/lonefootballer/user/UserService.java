package com.mls.lonefootballer.user;

import com.mls.lonefootballer.user.UserRecord;

import java.util.List;

public interface UserService {

    List<UserRecord> findAllUsers();
}
