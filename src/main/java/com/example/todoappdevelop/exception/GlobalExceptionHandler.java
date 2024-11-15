package com.example.todoappdevelop.exception;

import org.hibernate.annotations.processing.SQL;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.exception
 * <li>fileName       : GlobalExceptionHandler
 * <li>author         : daca0
 * <li>date           : 24. 11. 15.
 * <li>description    : 전역 예외 처리 클래스
 * </ul>
 * ===========================================================
 * <p>
 * 24. 11. 15.        daca0       최초 생성
 * </p>
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Valid 예외 처리 메서드
     *
     * @param e Valid로 인해 발생한 예외
     * @return 400 BAD_REQUEST, 예외 메세지 포함한 dto
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponseDto> handleValidException(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(
                new ExceptionResponseDto(
                        e.getFieldError().getDefaultMessage()
                ), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ExceptionResponseDto> handleSQLException(SQLIntegrityConstraintViolationException e) {
        return new ResponseEntity<>(
                new ExceptionResponseDto(
                        e.getLocalizedMessage()
                ), HttpStatus.BAD_REQUEST
        );
    }
}
