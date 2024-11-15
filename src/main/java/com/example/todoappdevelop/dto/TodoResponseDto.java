package com.example.todoappdevelop.dto;

import com.example.todoappdevelop.entity.Todo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.dto.todo
 * <li>fileName       : TodoResponseDto
 * <li>author         : daca0
 * <li>date           : 24. 11. 14.
 * <li>description    : 일정 응답 dto
 * </ul>
 * ===========================================================
 * <p>
 * 24. 11. 14.        daca0       최초 생성
 * </p>
 */

@Getter
@RequiredArgsConstructor
public class TodoResponseDto {

    private final Long id;

    private final String title;

    private final String contents;

    /**
     * 일정 엔티티를 dto로 매핑
     *
     * @param todo 일정 엔티티
     * @return 매핑된 dto
     */
    public static TodoResponseDto toDto(Todo todo) {
        return new TodoResponseDto(
                todo.getId(),
                todo.getTitle(),
                todo.getContents()
        );
    }
}
