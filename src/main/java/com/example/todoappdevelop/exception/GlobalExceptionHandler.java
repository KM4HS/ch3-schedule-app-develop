package com.example.todoappdevelop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.exception
 * <li>fileName       : GlobalExceptionHandler
 * <li>author         : daca0
 * <li>date           : 24. 11. 15.
 * <li>description    :
 * </ul>
 * ===========================================================
 * <p>
 * 24. 11. 15.        daca0       최초 생성
 * </p>
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponseDto> handleValidException(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(
                new ExceptionResponseDto(
                        e.getFieldError().getDefaultMessage()
                ), HttpStatus.BAD_REQUEST
        );
    }
}
