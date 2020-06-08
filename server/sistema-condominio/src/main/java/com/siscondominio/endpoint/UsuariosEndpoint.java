package com.siscondominio.endpoint;

//import java.time.LocalDateTime;

import com.siscondominio.model.Usuarios;
import com.siscondominio.repository.UserRepository;
//import com.siscondominio.util.dateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api")

public class UsuariosEndpoint {

    private final UserRepository userDAO;

    // @Autowired
    // UserRepository repository;

    @Autowired
    public UsuariosEndpoint(UserRepository userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(userDAO.findAll(), HttpStatus.OK);
    }

//     @GetMapping(path = "/{id}")
//     public ResponseEntity<?> getUsuariosById(@PathVariable("id") Long id) {
//         Optional<Usuarios> user = userDAO.findById(id);
//         if (user == null)
//             return new ResponseEntity<>(new CustomErrorType(errorMessage: "Student not found"), HttpStatus.NOT_FOUND);
//         return new ResponseEntity<>(user, HttpStatus.OK);
// }

@PostMapping
public ResponseEntity<?> save(@RequestBody Usuarios user){
    return new ResponseEntity<>(userDAO.save(user), HttpStatus.OK);
}

@DeleteMapping(path = "/{id}")
public ResponseEntity<?> delete(@PathVariable Long id){
    userDAO.deleteById(id);
    return new ResponseEntity<>(HttpStatus.OK);
}

@PutMapping
public ResponseEntity<?> update(@RequestBody Usuarios user){
    userDAO.save(user);
    return new ResponseEntity<>(HttpStatus.OK);
}

//private dateUtil dateUtil;

// TODO --> tratamento de erros vide https://www.youtube.com/watch?v=SdBtC-rXUck

// @RequestMapping(method = RequestMethod.GET, path = "/usuarios")
// @PreAuthorize("hasRole('ADMIN')")
// public Iterable<Usuarios> listaUsuarios() {
//     // System.out.println(dateUtil.formatLocalTimeToDatabaseStyle(LocalDateTime.now()));
//     return repository.findAll();

// }

// @PostMapping("/cadastro")
// @PreAuthorize("hasRole('ADMIN')")
// public Usuarios criaUsuario(@RequestBody @Valid final Usuarios usuario){
//     return repository.save(usuario);
// }

}
