package com.example.todoappdevelop.controller;

import com.example.todoappdevelop.dto.comment.CommentCreateRequestDto;
import com.example.todoappdevelop.dto.comment.CommentResponseDto;
import com.example.todoappdevelop.service.CommentService;
import jakarta.validation.Path;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.controller
 * <li>fileName       : CommentController
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
@RequestMapping("/")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/todos/{todoId}")
    public ResponseEntity<CommentResponseDto> createComment(
            @PathVariable Long todoId,
            @Valid @RequestBody CommentCreateRequestDto requestDto
    ) {

        CommentResponseDto commentResponseDto = commentService.createComment(todoId, requestDto.getContents());
        return new ResponseEntity<>(commentResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/todos/{todoId}/comments")
    public ResponseEntity<List<CommentResponseDto>> findAllCommentsByTodo(
            @PathVariable Long todoId
    ) {

        List<CommentResponseDto> commentResponseDtos = commentService.findAllCommentsByTodo(todoId);

        return new ResponseEntity<>(commentResponseDtos, HttpStatus.OK);
    }

    @DeleteMapping("/todos/{todoId}/comments/{id}")
    public ResponseEntity<Void> deleteComment(
            @PathVariable Long todoId,
            @PathVariable Long id
    ) {

        commentService.deleteComment(todoId, id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
