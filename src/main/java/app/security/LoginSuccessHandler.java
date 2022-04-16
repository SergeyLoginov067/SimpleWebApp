package app.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        String redirectUrl = request.getContextPath();
        if (userDetails.hasRole(Roles.ROLE_ADMIN)) {
            redirectUrl = "admin";
        } else if (userDetails.hasRole(Roles.ROLE_USER)) {
            redirectUrl = "user";
        }

        response.sendRedirect(redirectUrl);
    }

}
