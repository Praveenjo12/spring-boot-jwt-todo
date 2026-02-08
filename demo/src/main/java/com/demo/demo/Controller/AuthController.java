package com.demo.demo.Controller;

import com.demo.demo.Repository.UserRepository;
import com.demo.demo.Service.UserService;
import com.demo.demo.models.User;
import com.demo.demo.utils.JWTutils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JWTutils jwTutils;

    @PostMapping("/register")
    public ResponseEntity<String> registeruser(@RequestBody Map<String, String> body) {

        String email = body.get("email");
        String password = body.get("password");

        if (userRepository.findByEmail(email).isPresent()) {
            return new ResponseEntity<>("Email already exist", HttpStatus.CONFLICT);
        }

        userService.createUser(
                User.builder()
                        .email(email)
                        .password(passwordEncoder.encode(password)) // ✅ correct place
                        .build()
        );

        return new ResponseEntity<>("Successfully Created", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginuser(@RequestBody Map<String, String> body) {

        String email = body.get("email");
        String password = body.get("password");

        var userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            return new ResponseEntity<>("user not registered", HttpStatus.UNAUTHORIZED);
        }

        User user = userOptional.get();
        if (!passwordEncoder.matches(password, user.getPassword())) {
            return new ResponseEntity<>("Invalid user", HttpStatus.UNAUTHORIZED);
        }

        String token = jwTutils.generatetoken(email);
        return ResponseEntity.ok(Map.of("token", token));
    }
}
