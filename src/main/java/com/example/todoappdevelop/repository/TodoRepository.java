package com.example.todoappdevelop.repository;

import com.example.todoappdevelop.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.repository
 * <li>fileName       : TodoRepository
 * <li>author         : daca0
 * <li>date           : 24. 11. 14.
 * <li>description    : 일정 레포지토리
 * </ul>
 * ===========================================================
 * <p>
 * 24. 11. 14.        daca0       최초 생성
 * </p>
 */

public interface TodoRepository extends JpaRepository<Todo, Long> {
    /**
     * id로 일정을 조회하고, 없는 경우 throw
     *
     * @param id 일정 식별자
     * @return 조회된 일정
     */
    default Todo findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id)
        );
    }
}
