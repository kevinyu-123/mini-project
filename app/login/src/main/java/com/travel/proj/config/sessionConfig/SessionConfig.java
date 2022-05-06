package com.travel.proj.config.sessionConfig;

import com.travel.proj.model.User;
import com.travel.proj.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserRepository repository;

    private static final Map<String, HttpSession> sessions = new ConcurrentHashMap<>();

    //해당 메소드는 로그인 하는 곳에서 호출하는 메소드 이다.
    public synchronized static String loginSessionChecker(String compareId){
        String result = "";
        for( String key : sessions.keySet() ){
            HttpSession value = sessions.get(key);
            log.info((String) value.getAttribute("userInfo"));
            if(value != null &&  value.getAttribute("userInfo") != null && value.getAttribute("userInfo").toString().equals(compareId) ){
                result =  key.toString();
            }
        }
        removeSessionForDoubleLogin(result);
        return result;
    }

    private static boolean removeSessionForDoubleLogin(String userId){
        if(userId != null && userId.length() > 0){
            sessions.get(userId).invalidate();
            sessions.remove(userId);
        }
        return true;
    }

    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setMaxInactiveInterval(65);
        sessions.put(se.getSession().getId(),se.getSession());
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        if(sessions.get(se.getSession().getId()) != null){
            sessions.get(se.getSession().getId()).invalidate();
            sessions.remove(se.getSession().getId());

        }
    }
}
