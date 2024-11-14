package com.example.todoappdevelop.repository;

import com.example.todoappdevelop.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.repository
 * <li>fileName       : TodoRepository
 * <li>author         : daca0
 * <li>date           : 24. 11. 14.
 * <li>description    :
 * </ul>
 * ===========================================================
 * <p>
 * 24. 11. 14.        daca0       최초 생성
 * </p>
 */

public interface TodoRepository extends JpaRepository<Todo, Long> {
    default Todo findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id)
        );
    }
}
