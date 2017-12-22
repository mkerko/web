package by.bsu.security;

import by.bsu.domain.User;
import by.bsu.service.User.RetrieveUer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mikhail on 17.12.2017.
 */
@Component
public class RestAuthenticationSuccessHandler
        extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private RetrieveUer userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
            throws ServletException, IOException {
        User user = userService.execute(authentication.getName());
        SecurityUtils.sendResponse(response, HttpServletResponse.SC_OK, user);
    }
}