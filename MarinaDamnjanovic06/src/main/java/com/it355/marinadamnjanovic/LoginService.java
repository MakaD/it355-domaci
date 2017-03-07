package com.it355.marinadamnjanovic;

import org.springframework.stereotype.Service;

/**
 *
 * @author Marina
 */
@Service
public class LoginService {
    
    public String validateUser(LoginBean loginBean) {
        String userName = loginBean.getUserName();
        String password = loginBean.getPassword();
        if(userName.equals("user") && password.equals("user")) {
            return "true";
        }
        else {
            return "false";
        }
    }

}
