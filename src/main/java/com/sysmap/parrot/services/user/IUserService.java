package com.sysmap.parrot.services.user;

public interface IUserService {
    String createUser(CreateUserRequest request);

    FindUserResponse findUserByEmail(String email);
}
