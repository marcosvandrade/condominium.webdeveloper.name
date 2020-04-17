package com.siscondominio.controller;

import java.util.List;

import com.siscondominio.model.Usuarios;
import com.siscondominio.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api")

public class UsuarioController {

@Autowired
UsuarioRepository repository;

@GetMapping(value = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
public @ResponseBody List<Usuarios> getAllusers() {
  System.out.println("Get all Users...");

  //List<Customer> customers = new ArrayList<>();
  //repository.findAll().forEach(customers::add);

  //return customers;
  
  return repository.findAll();

}

}
