package com.gelber.pixeltree.Login;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class AccountSessionConfig implements WebMvcConfigurer {
    private AccountSessionInterceptor accountSessionInterceptor;

    public AccountSessionConfig(AccountSessionInterceptor accountSessionInterceptor) {
        this.accountSessionInterceptor = accountSessionInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        interceptorRegistry.addInterceptor(accountSessionInterceptor);
    }
}
