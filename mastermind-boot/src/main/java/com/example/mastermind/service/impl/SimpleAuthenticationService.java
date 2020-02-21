package com.example.mastermind.service.impl;

import com.example.mastermind.service.AuthenticationService;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Binnur Kurt (binnur.kurt@gmail.com)
 */
@Repository
public class SimpleAuthenticationService implements AuthenticationService {
    private Map<String, String> shadow;

    @PostConstruct
    public void init() {
        this.shadow = new HashMap<>();
        this.shadow.put("jack@example.com", "s3c-r3t");
        this.shadow.put("kate@example.com", "qw3-rty");
    }

    @Override
    public boolean authenticate(String username, String password) {
        String shadowPassword = shadow.get(username);
        if (shadowPassword != null && shadowPassword.equals(password))
            return true;
        return false;
    }

}
