package com.siscondominio.endpoint;

import java.util.Optional;

import com.siscondominio.model.Articles;
import com.siscondominio.repository.ArticlesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

public class ArticlesEndpoint {
    
    private final ArticlesRepository articlesDAO;

    @Autowired
    BCryptPasswordEncoder pe;

    // private ClienteService service;

    @Autowired
    public ArticlesEndpoint(ArticlesRepository articlesDAO) {
        this.articlesDAO = articlesDAO;
    }
   
    @PreAuthorize("hasAnyRole('CLIENTE')")
    @GetMapping(path= "articles")
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(articlesDAO.findAll(), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('CLIENTE')")
    @GetMapping(path = "articles/{id}")
    public ResponseEntity<?> getArticlesById(@PathVariable("id") Integer id) {
        Optional<Articles> article = articlesDAO.findById(id);
        if (article == null)
        return new ResponseEntity<>("Article not found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping(path= "articles")
    public ResponseEntity<?> save(@RequestBody Articles article){
        return new ResponseEntity<>(articlesDAO.save(article), HttpStatus.CREATED);
    }
    
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping(path = "articles")
    public ResponseEntity<?> update(@RequestBody  Articles article){
        return new ResponseEntity<>(articlesDAO.save(article), HttpStatus.OK);
    }
    
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(path = "articles/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
    articlesDAO.deleteById(id);
    return new ResponseEntity<>(HttpStatus.OK);
    }

}
