package com.siscondominio.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // System.out.println(passwordEncoder.encode( "admin123"));
        System.out.println(passwordEncoder.encode( "user123"));
    }
}