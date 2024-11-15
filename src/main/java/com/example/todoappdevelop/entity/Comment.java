package com.example.todoappdevelop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.entity
 * <li>fileName       : Comment
 * <li>author         : daca0
 * <li>date           : 24. 11. 15.
 * <li>description    :
 * </ul>
 * ===========================================================
 * <p>
 * 24. 11. 15.        daca0       최초 생성
 * </p>
 */

@Getter
@Entity
@Table
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String contents;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Setter
    @ManyToOne
    @JoinColumn(name = "todo_id")
    private Todo todo;

    public Comment(){}

    public Comment(String contents) {
        this.contents = contents;
    }

}
