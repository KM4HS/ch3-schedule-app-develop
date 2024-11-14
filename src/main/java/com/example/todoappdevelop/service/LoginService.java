package com.example.todoappdevelop.service;

import com.example.todoappdevelop.config.Const;
import com.example.todoappdevelop.config.PasswordEncoder;
import com.example.todoappdevelop.dto.user.LoginResponseDto;
import com.example.todoappdevelop.dto.user.UserResponseDto;
import com.example.todoappdevelop.entity.User;
import com.example.todoappdevelop.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.service
 * <li>fileName       : LoginService
 * <li>author         : daca0
 * <li>date           : 24. 11. 15.
 * <li>description    :
 * </ul>
 * ===========================================================
 * <p>
 * 24. 11. 15.        daca0       최초 생성
 * </p>
 */

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponseDto signup(@NotBlank String name, @NotBlank String username, @NotBlank String password) {

        String encodedPassword = passwordEncoder.encode(password);

        User user = new User(name, username, encodedPassword);

        User savedUser = userRepository.save(user);

        return UserResponseDto.toDto(savedUser);
    }

    public LoginResponseDto login(@NotBlank @Email String username, @NotNull String password, HttpServletRequest request) {

        User loginUser = userRepository.findByUsername(username).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.UNAUTHORIZED)
        );

        if(!passwordEncoder.matches(password, loginUser.getPassword())) {
           throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        HttpSession session = request.getSession();
        session.setAttribute(Const.LOGIN_USER, loginUser);

        return new LoginResponseDto(loginUser.getId());
    }

    /*public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
    }*/
}
