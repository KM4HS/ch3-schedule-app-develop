package com.example.todoappdevelop.controller;

import com.example.todoappdevelop.dto.todo.TodoCreateRequestDto;
import com.example.todoappdevelop.dto.todo.TodoResponseDto;
import com.example.todoappdevelop.dto.todo.TodoUpdateRequestDto;
import com.example.todoappdevelop.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.controller
 * <li>fileName       : TodoController
 * <li>author         : daca0
 * <li>date           : 24. 11. 14.
 * <li>description    : 일정 관련 기능 컨트롤러
 * </ul>
 * ===========================================================
 * <p>
 * 24. 11. 14.        daca0       최초 생성
 * </p>
 */

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    /**
     * 일정 생성 메서드
     *
     * @param requestDto 검증 거친 일정 생성 dto
     * @return 201 CREATED, 일정 응답 dto
     */
    @PostMapping
    public ResponseEntity<TodoResponseDto> createTodo(
            @Valid @RequestBody TodoCreateRequestDto requestDto
    ) {

        TodoResponseDto todoResponseDto = todoService.createTodo(requestDto.getTitle(), requestDto.getContents(), requestDto.getUsername());

        return new ResponseEntity<>(todoResponseDto, HttpStatus.CREATED);
    }

    /**
     * 일정 전체 조회 메서드
     *
     * @return 200 OK, 조회된 일정 리스트가 담긴 응답 dto
     */
    @GetMapping
    public ResponseEntity<List<TodoResponseDto>> findAllTodos() {

        List<TodoResponseDto> todoResponseDto = todoService.findAllTodos();

        return new ResponseEntity<>(todoResponseDto, HttpStatus.OK);
    }

    /**
     * 특정 일정 조회 메서드
     *
     * @param id 일정 식별자
     * @return 200 OK, 조회된 일정이 담긴 응답 dto
     */
    @GetMapping("/{id}")
    public ResponseEntity<TodoResponseDto> findTodoById(
            @PathVariable Long id
    ) {

        TodoResponseDto todoResponseDto = todoService.findTodoById(id);

        return new ResponseEntity<>(todoResponseDto, HttpStatus.OK);
    }

    /**
     * 일정 수정 dto
     *
     * @param id         일정 식별자
     * @param requestDto 검증 거친 일정 수정 요청 dto
     * @return 200 OK, 수정된 일정이 담긴 응답 dto
     */
    @PatchMapping("/{id}")
    public ResponseEntity<TodoResponseDto> updateTodo(
            @PathVariable Long id,
            @Valid @RequestBody TodoUpdateRequestDto requestDto
    ) {

        TodoResponseDto todoResponseDto = todoService.updateTodo(id, requestDto.getTitle(), requestDto.getContents());

        return new ResponseEntity<>(todoResponseDto, HttpStatus.OK);
    }

    /**
     * 일정 삭제 메서드
     *
     * @param id 일정 식별자
     * @return 200 OK
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(
            @PathVariable Long id
    ) {
        todoService.deleteTodo(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
