package com.example.todoappdevelop.service;

import com.example.todoappdevelop.dto.user.UserResponseDto;
import com.example.todoappdevelop.entity.User;
import com.example.todoappdevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.service
 * <li>fileName       : UserService
 * <li>author         : daca0
 * <li>date           : 24. 11. 14.
 * <li>description    : 유저 관련 기능 서비스
 * </ul>
 * ===========================================================
 * <p>
 * 24. 11. 14.        daca0       최초 생성
 * </p>
 */

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * 전체 유저 조회 메서드
     *
     * @return 조회된 유저 응답 dto 리스트
     */
    public List<UserResponseDto> findAllUsers() {

        List<User> users = userRepository.findAll();

        return users.stream().map(UserResponseDto::toDto).toList();
    }

    /**
     * 특정 유저 조회 메서드
     *
     * @param id 유저 식별자
     * @return 조회된 유저 담긴 응답 dto
     */
    public UserResponseDto findUserById(Long id) {

        User findUser = userRepository.findUserByIdOrElseThrow(id);

        return UserResponseDto.toDto(findUser);
    }

    /**
     * 유저 삭제 메서드
     *
     * @param id 유저 식별자
     */
    public void deleteUser(Long id) {
        User findUser = userRepository.findUserByIdOrElseThrow(id);
        userRepository.delete(findUser);
    }
}
