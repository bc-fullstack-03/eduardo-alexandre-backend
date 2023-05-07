package com.sysmap.parrot.api.user;

import com.sysmap.parrot.services.user.CreateUserRequest;
import com.sysmap.parrot.services.user.FindUserResponse;
import com.sysmap.parrot.services.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private IUserService _userService;

    @PostMapping()
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest request) {
        var response = _userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping()
    public  ResponseEntity<FindUserResponse> getUser(String email) {
        return ResponseEntity.status(HttpStatus.OK).body(_userService.findUserByEmail(email));
    }
}
