package com.example.todoappdevelop.repository;

import com.example.todoappdevelop.entity.Comment;
import com.example.todoappdevelop.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Objects;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.repository
 * <li>fileName       : CommentRepository
 * <li>author         : daca0
 * <li>date           : 24. 11. 15.
 * <li>description    :
 * </ul>
 * ===========================================================
 * <p>
 * 24. 11. 15.        daca0       최초 생성
 * </p>
 */

public interface CommentRepository extends JpaRepository<Comment, Long> {
    default List<Comment> findAllByTodo(Todo todo) {
        return findAll().stream().filter(c -> Objects.equals(c.getTodo().getId(), todo.getId())).toList();
    }
}
