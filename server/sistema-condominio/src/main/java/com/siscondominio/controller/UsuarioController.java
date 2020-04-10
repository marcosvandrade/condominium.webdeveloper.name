package com.siscondominio.controller;

import com.siscondominio.model.Usuarios;

import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api")

public class UsuarioController {

@Autowired
UsuarioRepository repository;

@PostMapping(path = "/cadastro")
  public @ResponseBody Usuarios postUsuario(@RequestBody Usuarios usuario) {
 
    Usuarios _usuario = repository.save(new Usuarios(usuario.getName(), usuario.getAge()));
    return _usuario;
  }

}
