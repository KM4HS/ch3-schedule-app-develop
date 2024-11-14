package com.example.todoappdevelop.controller;

import com.example.todoappdevelop.dto.user.LoginRequestDto;
import com.example.todoappdevelop.dto.user.LoginResponseDto;
import com.example.todoappdevelop.repository.LoginRepository;
import com.example.todoappdevelop.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.controller
 * <li>fileName       : SessionLoginController
 * <li>author         : daca0
 * <li>date           : 24. 11. 15.
 * <li>description    :
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
