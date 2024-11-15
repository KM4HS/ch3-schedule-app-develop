package com.example.todoappdevelop.dto.comment;

import com.example.todoappdevelop.entity.Comment;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.dto.comment
 * <li>fileName       : CommentResponseDto
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
@RequiredArgsConstructor
public class CommentResponseDto {

    private final String username;

    private final String todo_title;

    private final String contents;

    public CommentResponseDto(Comment comment) {
        this.username = comment.getTodo().getUser().getUsername();
        this.todo_title = comment.getTodo().getTitle();
        this.contents = comment.getContents();
    }
}
