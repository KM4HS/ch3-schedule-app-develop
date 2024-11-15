package com.example.todoappdevelop.controller;

import com.example.todoappdevelop.dto.LoginRequestDto;
import com.example.todoappdevelop.dto.LoginResponseDto;
import com.example.todoappdevelop.dto.UserRequestDto;
import com.example.todoappdevelop.dto.UserResponseDto;
import com.example.todoappdevelop.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.controller
 * <li>fileName       : SessionLoginController
 * <li>author         : daca0
 * <li>date           : 24. 11. 15.
 * <li>description    : 회원 가입, 로그인 관련 컨트롤러
 * </ul>
 * ===========================================================
 * <p>
 * 24. 11. 15.        daca0       최초 생성
 * </p>
 */

@RestController
@RequestMapping("/session")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    /**
     * 회원 가입 메서드
     *
     * @param requestDto name, username, password 포함
     * @return 201 CREATED, 생성된 유저 정보 담긴 응답 dto
     */
    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> signup(
            @Validated @RequestBody UserRequestDto requestDto
    ) {

        UserResponseDto userResponseDto = loginService.signup(requestDto.getName(), requestDto.getUsername(), requestDto.getPassword());

        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }

    /**
     * 로그인 메서드
     *
     * @param requestDto 로그인에 필요한 ID, PW
     * @param request    sessoin 생성을 위해 넘김
     * @return 200 OK, 로그인된 유저 id
     */
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(
            @Valid @RequestBody LoginRequestDto requestDto,
            HttpServletRequest request
    ) {
        LoginResponseDto loginResponseDto = loginService.login(requestDto.getUsername(), requestDto.getPassword(), request);

        return new ResponseEntity<>(loginResponseDto, HttpStatus.OK);
    }

    /*@PostMapping("/logout")
    public ResponseEntity<Void> logout(
            HttpServletRequest request
    ) {
        loginService.logout(request);

        return new ResponseEntity<>(HttpStatus.OK);
    }*/
}
