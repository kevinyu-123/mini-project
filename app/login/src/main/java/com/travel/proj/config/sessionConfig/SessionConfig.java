package com.travel.proj.config.sessionConfig;

import com.travel.proj.model.User;
import com.travel.proj.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private UserRepository repository;

    private static final Map<String, HttpSession> sessions = new ConcurrentHashMap<>();

    public synchronized static String getSessionidCheck(String type, String compareEmail){
        String result = "";
        for( String key : sessions.keySet() ){
            HttpSession hs = sessions.get(key);
            User user = new User();
            if(hs != null) {
                user = (User) hs.getAttribute(type);
                if(user != null && user.getEmail().toString().equals(compareEmail)) {
                    result = key.toString();
                }
            }
        }
        removeSessionForDoubleLogin(result);
        System.out.println(result+"2");
        return result;
    }

    private static void removeSessionForDoubleLogin(String userEmail){
        System.out.println("remove userEmail 1: " + userEmail);
        if(userEmail != null && userEmail.length() > 0){
            sessions.get(userEmail).invalidate();
            sessions.remove(userEmail);
        }
    }

    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setMaxInactiveInterval(65);
        sessions.put(se.getSession().getId(),se.getSession());
    }

    @Transactional
    public void sessionDestroyed(HttpSessionEvent se) {
        if(sessions.get(se.getSession().getId()) != null){
            sessions.get(se.getSession().getId()).invalidate();
            sessions.remove(se.getSession().getId());

        }
    }
}
