package com.siscondominio.controller;

import java.util.List;

import javax.validation.Valid;

import com.siscondominio.model.Usuarios;
import com.siscondominio.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")

public class UsuarioController {

@Autowired
UsuarioRepository repository;

@GetMapping("/usuarios")

public List<Usuarios> listaUsuarios(){

    return repository.findAll();

}

@PostMapping("/cadastro")
public Usuarios criaUsuario(@RequestBody @Valid Usuarios usuario){
    return repository.save(usuario);
}

}
