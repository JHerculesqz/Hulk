package com.firelord.security.configbak;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Deprecated
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    //#region onAuthenticationSuccess

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication)
            throws IOException, ServletException {
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        //#region note
//        for (GrantedAuthority auth : authentication.getAuthorities()) {
//            if ("ADMIN".equals(auth.getAuthority())) {
//                httpServletResponse.sendRedirect("/admin");
//            }
//        }
        //#endregion
    }

    //#endregion
}
