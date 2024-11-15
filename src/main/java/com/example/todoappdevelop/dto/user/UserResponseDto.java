package com.example.todoappdevelop.dto.user;

import com.example.todoappdevelop.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.dto.user
 * <li>fileName       : UserResponseDto
 * <li>author         : daca0
 * <li>date           : 24. 11. 14.
 * <li>description    : 유저 응답 dto
 * </ul>
 * ===========================================================
 * <p>
 * 24. 11. 14.        daca0       최초 생성
 * </p>
 */

@Getter
@RequiredArgsConstructor
public class UserResponseDto {

    private final Long id;

    private final String name;

    private final String username;

    /**
     * 유저 엔티티를 dto로 매핑
     *
     * @param user 유저 엔티티
     * @return 매핑된 dto
     */
    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getUsername()
        );
    }
}
