package com.siscondominio.endpoint;

import java.util.Optional;

import com.siscondominio.model.Usuarios;
import com.siscondominio.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api")

public class UsuariosEndpoint {

    private final UserRepository userDAO;

    @Autowired
    public UsuariosEndpoint(UserRepository userDAO) {
        this.userDAO = userDAO;
    }
   
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(path= "admin/usuarios")
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(userDAO.findAll(), HttpStatus.OK);
    }
    
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(path = "admin/usuarios/findByEmail/{email}")
    public ResponseEntity<?> findUsuariosByName(@PathVariable String email){
        return new ResponseEntity<>(userDAO.findByEmail(email), HttpStatus.OK);
    }
    
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(path = "admin/usuarios/{id}")
    public ResponseEntity<?> getUsuariosById(@PathVariable("id") Integer id) {
        Optional<Usuarios> user = userDAO.findById(id);
        if (user == null)
        return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping(path= "admin/cadastro")
    public ResponseEntity<?> save(@RequestBody Usuarios user){
        return new ResponseEntity<>(userDAO.save(user), HttpStatus.CREATED);
    }
    
//     @PreAuthorize("hasAnyRole('ADMIN')")
//     @PutMapping(path = "admin/usuarios/{id}")
//     public ResponseEntity<?> update(@RequestBody Usuarios user){
//     userDAO.save(user);
//     return new ResponseEntity<>(HttpStatus.OK);
// }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(path = "admin/usuarios/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
    userDAO.deleteById(id);
    return new ResponseEntity<>(HttpStatus.OK);
}

}
