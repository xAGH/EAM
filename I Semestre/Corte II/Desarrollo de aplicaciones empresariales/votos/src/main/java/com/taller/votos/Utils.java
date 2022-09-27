package com.taller.votos;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Utils {
    
    public static String EncryptPassword(String pass) {
        return new BCryptPasswordEncoder().encode(pass);
    }

}
