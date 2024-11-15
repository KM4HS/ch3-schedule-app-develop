package com.example.todoappdevelop.repository;

import com.example.todoappdevelop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.repository
 * <li>fileName       : UserRepository
 * <li>author         : daca0
 * <li>date           : 24. 11. 14.
 * <li>description    : 유저 레포지토리
 * </ul>
 * ===========================================================
 * <p>
 * 24. 11. 14.        daca0       최초 생성
 * </p>
 */

public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * username으로 유저를 찾음
     *
     * @param username 아이디(이메일 형식)
     * @return 조회된 User
     */
    Optional<User> findByUsername(String username);

    /**
     * username으로 유저를 찾고, 없을시 throw
     *
     * @param username 아이디(이메일 형식)
     * @return 조회된 User
     */
    default User findUserByUsernameOrElseThrow(String username) {
        return findByUsername(username).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist username = " + username)
        );
    }

    /**
     * id로 유저를 찾고, 없을시 throw
     *
     * @param id 유저 식별자
     * @return 조회된 User
     */
    default User findUserByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id)
        );
    }
}
