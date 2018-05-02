package bookStore.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthetificationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public String determineTargetUrl(HttpServletRequest request, HttpServletResponse response){
        Authentication authentication1 = SecurityContextHolder.getContext().getAuthentication();
        String role = authentication1.getAuthorities().toString();

        if (role.contains("Administrator"))
            return "/administrator";
        else if (role.contains("Employee"))
            return "/regularUser";
        return "";
    }
}

