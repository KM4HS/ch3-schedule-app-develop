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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.service
 * <li>fileName       : LoginService
 * <li>author         : daca0
 * <li>date           : 24. 11. 15.
 * <li>description    : 로그인 관련 기능 서비스
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

    /**
     * 회원가입 메서드
     *
     * @param name     이름
     * @param username 아이디(이메일 형식)
     * @param password 비밀번호, db에는 암호화하여 저장
     * @return 가입한 유저 정보가 담긴 응답 dto
     */
    @Transactional
    public UserResponseDto signup(@NotBlank String name, @NotBlank String username, @NotBlank String password) {

        String encodedPassword = passwordEncoder.encode(password);

        User user = new User(name, username, encodedPassword);
        User savedUser = userRepository.save(user);

        return UserResponseDto.toDto(savedUser);
    }

    /**
     * 로그인 메서드
     *
     * @param username 아이디(이메일 형식)
     * @param password 비밀번호
     * @return 로그인된 유저 id를 담은 응답 dto
     */
    public LoginResponseDto login(@NotBlank @Email String username, @NotNull String password, HttpServletRequest request) {

        User loginUser = userRepository.findByUsername(username).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.UNAUTHORIZED)
        );

        if (!passwordEncoder.matches(password, loginUser.getPassword())) {
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
