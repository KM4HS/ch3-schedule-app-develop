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
 * <li>description    : 일정 관련 기능 서비스
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

    /**
     * 일정 생성 메서드
     *
     * @param title    제목
     * @param contents 내용
     * @param username 작성자 아이디
     * @return 생성된 일정이 담긴 응답 dto
     */
    public TodoResponseDto createTodo(@NotBlank String title, @NotBlank String contents, @NotBlank String username) {

        Todo todo = new Todo(title, contents);
        todo.setUser(userRepository.findUserByUsernameOrElseThrow(username));
        Todo savedTodo = todoRepository.save(todo);

        return TodoResponseDto.toDto(savedTodo);
    }

    /**
     * 전체 일정 조회 메서드
     *
     * @return 조회된 일정 응답 dto 리스트
     */
    public List<TodoResponseDto> findAllTodos() {

        List<Todo> todos = todoRepository.findAll();

        return todos.stream().map(TodoResponseDto::toDto).toList();
    }

    /**
     * 특정 일정 조회 메서드
     *
     * @param id 일정 식별자
     * @return 조회된 일정 담긴 응답 dto
     */
    public TodoResponseDto findTodoById(Long id) {

        Todo findTodo = todoRepository.findByIdOrElseThrow(id);

        return TodoResponseDto.toDto(findTodo);
    }

    /**
     * 일정 수정 메서드
     *
     * @param id       일정 식별자
     * @param title    수정할 제목
     * @param contents 수정할 내용
     * @return 수정된 일정 담긴 응답 dto
     */
    public TodoResponseDto updateTodo(Long id, @NotBlank String title, @NotNull String contents) {

        Todo findTodo = todoRepository.findByIdOrElseThrow(id);
        findTodo.updateTodo(title, contents);

        return TodoResponseDto.toDto(findTodo);
    }

    /**
     * 일정 삭제 메서드
     *
     * @param id 일정 식별자
     */
    public void deleteTodo(Long id) {
        Todo findTodo = todoRepository.findByIdOrElseThrow(id);
        todoRepository.delete(findTodo);
    }
}
