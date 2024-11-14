package com.example.todoappdevelop.controller;

import com.example.todoappdevelop.dto.todo.TodoCreateRequestDto;
import com.example.todoappdevelop.dto.todo.TodoResponseDto;
import com.example.todoappdevelop.dto.todo.TodoUpdateRequestDto;
import com.example.todoappdevelop.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.controller
 * <li>fileName       : TodoController
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
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    // 일정 생성
    @PostMapping
    public ResponseEntity<TodoResponseDto> createTodo(
            @Validated @RequestBody TodoCreateRequestDto requestDto
    ) {

        TodoResponseDto todoResponseDto = todoService.createTodo(requestDto.getTitle(), requestDto.getContents(), requestDto.getUsername());

        return new ResponseEntity<>(todoResponseDto, HttpStatus.CREATED);
    }

    // 일정 전체 조회
    @GetMapping
    public ResponseEntity<List<TodoResponseDto>> findAllTodos() {

        List<TodoResponseDto> todoResponseDto = todoService.findAllTodos();

        return new ResponseEntity<>(todoResponseDto, HttpStatus.OK);
    }

    // 특정 일정 조회
    @GetMapping("/{id}")
    public ResponseEntity<TodoResponseDto> findTodoById(
            @PathVariable Long id
    ) {

        TodoResponseDto todoResponseDto = todoService.findTodoById(id);

        return new ResponseEntity<>(todoResponseDto, HttpStatus.OK);
    }

    // 일정 수정
    @PatchMapping("/{id}")
    public ResponseEntity<TodoResponseDto> updateTodo(
            @PathVariable Long id,
            @Validated @RequestBody TodoUpdateRequestDto requestDto
    ) {

        TodoResponseDto todoResponseDto = todoService.updateTodo(id, requestDto.getTitle(), requestDto.getContents());

        return new ResponseEntity<>(todoResponseDto, HttpStatus.OK);
    }

    // 일정 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(
            @PathVariable Long id
    ) {
        todoService.deleteTodo(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
