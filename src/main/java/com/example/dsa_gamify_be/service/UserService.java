package com.example.dsa_gamify_be.service;

import com.example.dsa_gamify_be.dto.userDto.user.UserCreationRequestDto;
import com.example.dsa_gamify_be.dto.userDto.user.UserLoginRequestDto;
import com.example.dsa_gamify_be.dto.userDto.user.UserUpdateRequestDto;
import com.example.dsa_gamify_be.enums.UserRoleEnum;
import com.example.dsa_gamify_be.model.User;
import com.example.dsa_gamify_be.repository.UserRepository;
import com.example.dsa_gamify_be.utils.JwtUtil;
import com.example.dsa_gamify_be.utils.PasswordsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtUtil jwtUtil;

    private boolean isUsernameExisted(String username){
        return userRepository.findByUsername(username).isPresent();
    };

    private String getUsername(String id){
        Optional<User> user = userRepository.findById(id);
        return user.map(User::getUsername).orElse(null);
    }

    public boolean isAdmin(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.filter(value -> Objects.equals(value.getRole(), UserRoleEnum.admin)).isPresent();
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public ResponseEntity<?> signUp(UserCreationRequestDto req) {
        User user = new User(
                req.getUsername(),
                req.getFullName(),
                PasswordsUtil.hashPassword(req.getPasswords())
        );

        try{
            userRepository.save(user);
            return  ResponseEntity.ok("Đăng ký thành công");
        }catch (Exception e){
            System.out.println(e);
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public User getById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public ResponseEntity<String> updateUser(User user,UserUpdateRequestDto req){
        if (Objects.nonNull(req.getFullName())){
            user.setFullName(req.getFullName());
        }

        if (Objects.nonNull(req.getUsername()) && Objects.equals(req.getUsername(),user.getUsername())){
            if (isUsernameExisted(req.getUsername())){
                user.setUsername(req.getUsername());
            }
        }

        if (Objects.nonNull(req.getPasswords()) && Objects.equals(req.getPasswords(),user.getPasswords())){
            user.setPasswords(req.getPasswords());
        }

        if (Objects.nonNull(req.getOperatorId())){
            user.setUpdatedBy(getUsername(req.getOperatorId()));
        }else{
            user.setUpdatedBy(user.getUsername());
        }

        try{
            userRepository.save(user);
            return  ResponseEntity.ok("Cập nhật dữ liệu thành công");
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<String> userLogin(UserLoginRequestDto req) {
        Optional<User> user = userRepository.findByUsername(req.getUsername());
        if (user.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        if (!PasswordsUtil.checkPassword(req.getPasswords(),user.get().getPasswords())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(jwtUtil.createToken(user.get().getId(),user.get().getRole()));
    }
}
