package com.gelber.pixeltree.Login;

import com.gelber.pixeltree._Model.User;
import com.gelber.pixeltree._Repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AccountSessionInterceptor implements HandlerInterceptor {
    private UserRepository userRepository;

    public AccountSessionInterceptor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        if (request.getUserPrincipal() != null) {
            if (request.getSession().getAttribute("user") == null) {
                User user = userRepository.findByUsername(request.getUserPrincipal().getName());
                request.getSession().setAttribute("user", user);
            }
        }
        return true;
    }
}
