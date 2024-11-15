package com.example.todoappdevelop.controller;

import com.example.todoappdevelop.dto.UserResponseDto;
import com.example.todoappdevelop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.controller
 * <li>fileName       : UserController
 * <li>author         : daca0
 * <li>date           : 24. 11. 14.
 * <li>description    : 유저 관련 기능 컨트롤러
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

    /**
     * 전체 유저 조회 메서드
     *
     * @return 200 OK, 조회된 유저 목록이 담긴 응답 dto
     */
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAllUsers() {

        List<UserResponseDto> userResponseDto = userService.findAllUsers();

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    /**
     * 특정 유저 조회 메서드
     *
     * @param id 유저 식별자
     * @return 200 OK, 조회된 유저 정보 담긴 응답 dto
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findUserById(
            @PathVariable Long id
    ) {

        UserResponseDto userResponseDto = userService.findUserById(id);

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    /**
     * 유저 삭제 메서드
     *
     * @param id 유저 식별자
     * @return 200 OK
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable Long id
    ) {

        userService.deleteUser(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
