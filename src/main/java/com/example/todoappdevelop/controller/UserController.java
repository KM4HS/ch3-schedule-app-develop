package com.example.todoappdevelop.controller;

import com.example.todoappdevelop.dto.user.UserRequestDto;
import com.example.todoappdevelop.dto.user.UserResponseDto;
import com.example.todoappdevelop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.controller
 * <li>fileName       : UserController
 * <li>author         : daca0
 * <li>date           : 24. 11. 14.
 * <li>description    :
 * </ul>
 * ===========================================================
 * <p>
 * 24. 11. 14.        daca0       최초 생성
 * </p>
 */

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 전체 조회
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAllUsers() {

        List<UserResponseDto> userResponseDto = userService.findAllUsers();

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    // 특정 조회
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findUserById(
            @PathVariable Long id
    ) {

        UserResponseDto userResponseDto = userService.findUserById(id);

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    // 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable Long id
    ) {

        userService.deleteUser(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
