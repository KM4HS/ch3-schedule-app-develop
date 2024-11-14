package com.example.todoappdevelop.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.dto.user
 * <li>fileName       : UserRequestDto
 * <li>author         : daca0
 * <li>date           : 24. 11. 14.
 * <li>description    :
 * </ul>
 * ===========================================================
 * <p>
 * 24. 11. 14.        daca0       최초 생성
 * </p>
 */

@Getter
@RequiredArgsConstructor
public class UserRequestDto {

    @NotBlank
    private final String name;

    @NotBlank
    private final String username;

    @NotBlank
    private final String password;
}
