package com.example.todoappdevelop.service;

import com.example.todoappdevelop.dto.comment.CommentResponseDto;
import com.example.todoappdevelop.entity.Comment;
import com.example.todoappdevelop.entity.Todo;
import com.example.todoappdevelop.entity.User;
import com.example.todoappdevelop.repository.CommentRepository;
import com.example.todoappdevelop.repository.TodoRepository;
import com.example.todoappdevelop.repository.UserRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.service
 * <li>fileName       : CommentService
 * <li>author         : daca0
 * <li>date           : 24. 11. 15.
 * <li>description    :
 * </ul>
 * ===========================================================
 * <p>
 * 24. 11. 15.        daca0       최초 생성
 * </p>
 */

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final TodoRepository todoRepository;

    public CommentResponseDto createComment(@NotNull Long todoId, @NotNull String contents) {

        Todo findTodo = todoRepository.findByIdOrElseThrow(todoId);

        Comment comment = new Comment(contents);
        comment.setTodo(findTodo);

        Comment savedComment = commentRepository.save(comment);

        return new CommentResponseDto(savedComment);
    }

    public List<CommentResponseDto> findAllCommentsByTodo(Long todoId) {

        Todo findTodo = todoRepository.findByIdOrElseThrow(todoId);

        List<Comment> comments = commentRepository.findAllByTodo(findTodo);

        return comments.stream().map(CommentResponseDto::new).toList();
    }

    public void deleteComment(Long todoId, Long id) {

        Comment findComment = commentRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND)
        );

        if(findComment.getTodo().getId().equals(todoId)) {
            commentRepository.delete(findComment);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
