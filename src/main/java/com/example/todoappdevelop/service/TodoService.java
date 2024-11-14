package com.example.todoappdevelop.service;

import com.example.todoappdevelop.dto.todo.TodoResponseDto;
import com.example.todoappdevelop.entity.Todo;
import com.example.todoappdevelop.repository.TodoRepository;
import com.example.todoappdevelop.repository.UserRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.service
 * <li>fileName       : TodoService
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
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public TodoResponseDto createTodo(@NotBlank String title, @NotBlank String contents, @NotBlank String username) {

        Todo todo = new Todo(title, contents);
        todo.setUser(userRepository.findUserByUsernameOrElseThrow(username));
        Todo savedTodo = todoRepository.save(todo);

        return TodoResponseDto.toDto(savedTodo);
    }

    public List<TodoResponseDto> findAllTodos() {

        List<Todo> todos = todoRepository.findAll();

        return todos.stream().map(TodoResponseDto::toDto).toList();
    }

    public TodoResponseDto findTodoById(Long id) {

        Todo findTodo = todoRepository.findByIdOrElseThrow(id);

        return TodoResponseDto.toDto(findTodo);
    }

    public TodoResponseDto updateTodo(Long id, @NotBlank String title, @NotNull String contents) {

        Todo findTodo = todoRepository.findByIdOrElseThrow(id);

        findTodo.updateTodo(title, contents);

        return TodoResponseDto.toDto(findTodo);
    }

    public void deleteTodo(Long id) {
        Todo findTodo = todoRepository.findByIdOrElseThrow(id);
        todoRepository.delete(findTodo);
    }
}
