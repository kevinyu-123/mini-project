package com.travel.proj.config.sessionConfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Configuration
@WebListener
public class SessionConfig implements HttpSessionListener {

    private static final Map<String, HttpSession> sessions = new ConcurrentHashMap<>();

    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setMaxInactiveInterval(65);
        sessions.put(se.getSession().getId(),se.getSession());
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session end");
        if(sessions.get(se.getSession().getId()) != null){
            sessions.get(se.getSession().getId()).invalidate();
            sessions.remove(se.getSession().getId());

        }
    }
}
