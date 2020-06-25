package com.gelber.pixeltree._Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationFailureLockedEvent;

@Configuration
public class EventListenerConfig {

    @EventListener
    public void handleErrorEvent(AuthenticationFailureLockedEvent event) {
        System.out.println("Locked!");
    }

    @EventListener
    public void handleErrorEvent(AuthenticationFailureBadCredentialsEvent event) {
        System.out.println("Bad credentials!");
    }

}
