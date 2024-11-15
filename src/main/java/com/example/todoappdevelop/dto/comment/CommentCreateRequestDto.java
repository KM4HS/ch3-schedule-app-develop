package com.example.todoappdevelop.dto.comment;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.dto.comment
 * <li>fileName       : CommentRequestDto
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
public class CommentCreateRequestDto {

    @NotNull
    private final String username;

    @NotNull
    private final String contents;
}
