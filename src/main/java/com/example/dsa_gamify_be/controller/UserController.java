package com.example.dsa_gamify_be.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.dsa_gamify_be.dto.userDto.user.UserCreationRequestDto;
import com.example.dsa_gamify_be.dto.userDto.user.UserLoginRequestDto;
import com.example.dsa_gamify_be.dto.userDto.user.UserUpdateRequestDto;
import com.example.dsa_gamify_be.model.User;
import com.example.dsa_gamify_be.service.UserService;
import com.example.dsa_gamify_be.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("api/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    JwtUtil jwtUtil;

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(@RequestParam String operator_id){
        if (!userService.isAdmin(operator_id)){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        List<User> users = userService.getAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{token}")
    public ResponseEntity<User> getByToken(@PathVariable String token){
        DecodedJWT obj = jwtUtil.decodeToken(token);
        User user = userService.getById(obj.getId());
        if (Objects.equals(user,null)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody @Validated UserLoginRequestDto req){
        return userService.userLogin(req);
    }

    @PostMapping
    public ResponseEntity<?> signUp(@RequestBody @Validated UserCreationRequestDto req) {
        return userService.signUp(req);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateDetail(@PathVariable String id, @RequestBody @Validated UserUpdateRequestDto req){
        User user = userService.getById(id);
        if (Objects.isNull(user)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else{
            if (!Objects.equals(req.getConfirmPasswords(),user.getPasswords())){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }
        return userService.updateUser(user,req);
    }
}
