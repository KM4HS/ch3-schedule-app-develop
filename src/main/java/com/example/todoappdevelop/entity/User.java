package com.example.todoappdevelop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.entity
 * <li>fileName       : User
 * <li>author         : daca0
 * <li>date           : 24. 11. 14.
 * <li>description    : 유저 엔티티
 * </ul>
 * ===========================================================
 * <p>
 * 24. 11. 14.        daca0       최초 생성
 * </p>
 */

@Getter
@Entity
@Table
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 4)
    @Size(max = 4)
    private String name;

    @Column(nullable = false, unique = true, length = 50)
    @Size(max = 50)
    private String username;

    @Column(nullable = false, length = 50)
    @Size(max = 50)
    private String password;

    protected User(){
    }

    /**
     * 유저 회원가입 메서드를 위한 생성자
     *
     * @param name 이름
     * @param username 아이디(이메일 형식)
     * @param password 비밀번호
     */
    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }
}
