package com.example.todoappdevelop.repository;

import com.example.todoappdevelop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.repository
 * <li>fileName       : LoginRepository
 * <li>author         : daca0
 * <li>date           : 24. 11. 15.
 * <li>description    :
 * </ul>
 * ===========================================================
 * <p>
 * 24. 11. 15.        daca0       최초 생성
 * </p>
 */

public interface LoginRepository extends JpaRepository<User, Long> {
}
