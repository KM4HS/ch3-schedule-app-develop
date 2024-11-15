package com.example.todoappdevelop.config;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.config
 * <li>fileName       : PasswordEncoder
 * <li>author         : daca0
 * <li>date           : 24. 11. 15.
 * <li>description    : 비밀번호 암호화 클래스, 예제와 동일
 * </ul>
 * ===========================================================
 * <p>
 * 24. 11. 15.        daca0       최초 생성
 * </p>
 */


@Component
public class PasswordEncoder {

    public String encode(String rawPassword) {
        return BCrypt.withDefaults().hashToString(BCrypt.MIN_COST, rawPassword.toCharArray());
    }

    public boolean matches(String rawPassword, String encodedPassword) {
        BCrypt.Result result = BCrypt.verifyer().verify(rawPassword.toCharArray(), encodedPassword);
        return result.verified;
    }
}
