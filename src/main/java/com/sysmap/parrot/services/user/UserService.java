package com.sysmap.parrot.services.user;

import com.sysmap.parrot.data.user.IUserRepository;
import com.sysmap.parrot.entities.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository _userRepository;
    public String createUser(CreateUserRequest request) {

        var user = new User(request.name, request.email, request.password);

        _userRepository.save(user);

        return user.getId().toString();
    }

    public FindUserResponse findUserByEmail(String email) {
        var user = _userRepository.findUserByEmail(email).get();

        var response = new FindUserResponse(user.getId(), user.getName(), user.getEmail());

        return response;
    }
}
