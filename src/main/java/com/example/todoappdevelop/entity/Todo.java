package com.example.todoappdevelop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.entity
 * <li>fileName       : Todo
 * <li>author         : daca0
 * <li>date           : 24. 11. 14.
 * <li>description    : 일정 엔티티
 * </ul>
 * ===========================================================
 * <p>
 * 24. 11. 14.        daca0       최초 생성
 * </p>
 */

@Getter
@Entity
@Table
public class Todo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    @Size(max = 10)
    private String title;

    @Column(columnDefinition = "longtext")
    private String contents;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    protected Todo() {
    }

    /**
     * 일정 생성 메서드를 위한 생성자
     *
     * @param title    제목
     * @param contents 내용
     */
    public Todo(String title, String contents, User user) {
        this.title = title;
        this.contents = contents;
        this.user = user;
    }

    /**
     * 일정 수정 메서드
     *
     * @param title    수정할 제목
     * @param contents 수정할 내용
     */
    public void updateTodo(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
