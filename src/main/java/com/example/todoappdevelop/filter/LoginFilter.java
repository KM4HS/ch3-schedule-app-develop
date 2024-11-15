package com.example.todoappdevelop.filter;

import com.example.todoappdevelop.config.Const;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

/**
 * <ul>
 * <li>packageName    : com.example.todoappdevelop.filter
 * <li>fileName       : LoginFilter
 * <li>author         : daca0
 * <li>date           : 24. 11. 14.
 * <li>description    : 로그인 여부 확인을 위한 필터
 * </ul>
 * ===========================================================
 * <p>
 * 24. 11. 14.        daca0       최초 생성
 * </p>
 */

@Slf4j
public class LoginFilter implements Filter {

    private static final String[] WHITE_LIST = {"/", "/session/signup", "/session/login"};


    /**
     * 로그인이 필요한 uri 대상으로 필터링
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // 로그인 체크가 필요한 URI인 경우
        if (!isWhiteList(requestURI)) {
            HttpSession session = httpRequest.getSession(false);

            if (session == null || session.getAttribute(Const.LOGIN_USER) == null) {
                httpResponse.sendError(401);
                return;
            }
        }

        chain.doFilter(request, httpResponse);
    }

    /**
     * URI가 {@code WHITE_LIST}에 포함되어있는가를 확인
     *
     * @param requestURI 요청 URI
     * @return {@code WHITE_LIST}에 포함된 경우 true
     */
    private boolean isWhiteList(String requestURI) {
        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
    }
}
