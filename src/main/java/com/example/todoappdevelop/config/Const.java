package com.example.todoappdevelop.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.config
 * <li>fileName       : Const
 * <li>author         : daca0
 * <li>date           : 24. 11. 15.
 * <li>description    : 로그인 세션 키 상수 저장용 클래스
 * </ul>
 * ===========================================================
 * <p>
 * 24. 11. 15.        daca0       최초 생성
 * </p>
 */

@Getter
@RequiredArgsConstructor
public enum Const {
    LOGIN_USER ("loginUser");

    private final String key;
}
