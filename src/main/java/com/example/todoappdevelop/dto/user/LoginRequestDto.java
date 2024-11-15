package com.example.todoappdevelop.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.dto.user
 * <li>fileName       : LoginRequestDto
 * <li>author         : daca0
 * <li>date           : 24. 11. 14.
 * <li>description    : 로그인 요청 dto
 * </ul>
 * ===========================================================
 * <p>
 * 24. 11. 14.        daca0       최초 생성
 * </p>
 */

@Getter
@RequiredArgsConstructor
public class LoginRequestDto {

    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식에 맞지 않습니다.")
    private final String username;

    @NotNull
    private final String password;
}
