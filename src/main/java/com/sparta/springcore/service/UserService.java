package com.sparta.springcore.service;

import com.sparta.springcore.dto.SignupRequestDto;
import com.sparta.springcore.model.User;
import com.sparta.springcore.model.UserRoleEnum;
import com.sparta.springcore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
//    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private static final String ADMIN_TOKEN = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC";

    @Autowired
//    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(SignupRequestDto requestDto) {
        System.out.println("1");
        // 회원 ID 중복 확인
        String username = requestDto.getUsername();
        System.out.println("username = " + username);

        Optional<User> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
        }
        System.out.println("2");



            System.out.println("여긴 오지?");
        // 패스워드 암호화
//        String password = passwordEncoder.encode(requestDto.getPassword());
        String password = requestDto.getPassword();
        System.out.println("password = " + password);

        // 회원 비밀 번호 확인
        String passwordCk = requestDto.getPasswordCk();
        System.out.println("passwordCk = " + passwordCk);
        if(!password.equals(passwordCk)) {
            throw new IllegalArgumentException("비밀번호가 같지 않습니다");
        }
        String email = requestDto.getEmail();
        System.out.println("email = " + email);

        // 사용자 ROLE 확인
        UserRoleEnum role = UserRoleEnum.USER;
            System.out.println("3");
        if (requestDto.isAdmin()) {
            if (!requestDto.getAdminToken().equals(ADMIN_TOKEN)) {
                throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가능합니다.");
            }
            role = UserRoleEnum.ADMIN;
        }

            System.out.println("4");
        User user = new User(username,password ,passwordCk, email ,role );
            System.out.println("user = " + user);
            userRepository.save(user);
        }

}