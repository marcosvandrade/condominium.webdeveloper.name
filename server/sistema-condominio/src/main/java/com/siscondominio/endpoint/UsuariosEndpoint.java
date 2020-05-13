package com.siscondominio.endpoint;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import com.siscondominio.model.Usuarios;
import com.siscondominio.repository.UsuarioRepository;
import com.siscondominio.util.dateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api")

public class UsuariosEndpoint {

@Autowired
UsuarioRepository repository;

@Autowired
private dateUtil dateUtil;
@RequestMapping(method = RequestMethod.GET, path = "/usuarios")
public List<Usuarios> listaUsuarios(){
    // System.out.println(dateUtil.formatLocalTimeToDatabaseStyle(LocalDateTime.now()));
    return repository.findAll();

}

@PostMapping("/cadastro")
public Usuarios criaUsuario(@RequestBody @Valid Usuarios usuario){
    return repository.save(usuario);
}

}
