package com.gelber.pixeltree._Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;

@Configuration
public class EventListenerConfig {

    /**
     * Callback function which fires when a user logs in with invalid credentials.
     * @param event Contains information about the incorrect login.
     */
    @EventListener
    public void handleErrorEvent(AuthenticationFailureBadCredentialsEvent event) {
        System.out.println("Bad credentials!");
    }

}
