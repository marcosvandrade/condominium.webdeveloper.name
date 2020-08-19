package com.siscondominio.services;

import java.text.ParseException;
import java.util.Arrays;

import com.siscondominio.enums.Perfil;
import com.siscondominio.model.Usuarios;
import com.siscondominio.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DBService {
  
  @Autowired
  private BCryptPasswordEncoder pe;

  @Autowired
  private UserRepository userRepository;
 
   public void instantiateTestDatabase() throws ParseException {
   
    Usuarios admin = new Usuarios("Administrador", "68862784600", "101", "(61) 9 9965-2253",
                                                     "admin@admin.com", pe.encode("admin123"));
    
    Usuarios user = new Usuarios("Usuário", "68862784601", "102", "(61) 9 9965-2254",
    "user@user.com", pe.encode("user123"));  
   
    admin.addPerfil(Perfil.ADMIN);
    user.addPerfil(Perfil.CLIENTE);

   admin.

    
  }
    
}