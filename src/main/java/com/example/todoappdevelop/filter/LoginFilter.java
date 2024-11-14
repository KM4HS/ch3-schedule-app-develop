package com.example.todoappdevelop.filter;

import com.example.todoappdevelop.config.Const;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.PatternMatchUtils;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.filter
 * <li>fileName       : LoginFilter
 * <li>author         : daca0
 * <li>date           : 24. 11. 14.
 * <li>description    :
 * </ul>
 * ===========================================================
 * <p>
 * 24. 11. 14.        daca0       최초 생성
 * </p>
 */

@Slf4j
public class LoginFilter implements Filter {

    private static final String[] WHITE_LIST = {"/", "/session/signup", "/session/login"};


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        String requestURI = httpRequest.getRequestURI();

        HttpServletResponse httpResponse = (HttpServletResponse)response;

        // 로그인 체크가 필요한 URI인 경우
        if(!isWhiteList(requestURI)) {
            HttpSession session = httpRequest.getSession(false);

            if(session == null || session.getAttribute(Const.LOGIN_USER) == null) {
                httpResponse.sendError(401);
                return;
            }
        }
        log.info("로그인 확인 성공");
        chain.doFilter(request, httpResponse);
    }

    private boolean isWhiteList(String requestURI) {
        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
    }
}
