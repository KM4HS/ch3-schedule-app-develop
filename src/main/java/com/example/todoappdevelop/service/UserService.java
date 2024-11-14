package com.example.todoappdevelop.service;

import com.example.todoappdevelop.config.PasswordEncoder;
import com.example.todoappdevelop.dto.user.UserResponseDto;
import com.example.todoappdevelop.entity.User;
import com.example.todoappdevelop.repository.UserRepository;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.service
 * <li>fileName       : UserService
 * <li>author         : daca0
 * <li>date           : 24. 11. 14.
 * <li>description    :
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

    public List<UserResponseDto> findAllUsers() {

        List<User> users = userRepository.findAll();

        return users.stream().map(UserResponseDto::toDto).toList();
    }

    public UserResponseDto findUserById(Long id) {

        User findUser = userRepository.findUserByIdOrElseThrow(id);

        return UserResponseDto.toDto(findUser);
    }

    public void deleteUser(Long id) {
        User findUser = userRepository.findUserByIdOrElseThrow(id);
        userRepository.delete(findUser);
    }
}
