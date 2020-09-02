package com.siscondominio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "articles")

public class Articles {
    
    public Articles () {

    }

    public Articles(Integer id, String title, String content, Usuarios user) {
        super();
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
    }

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;

@ManyToOne
@JoinColumn(name="id")
private Usuarios user;

// @ManyToOne
// @JoinTable(name="usuarios",
//     joinColumns = @JoinColumn(name = "userid", referencedColumnName = "id"))
// private Usuarios user;

@NotEmpty
@Column(name = "title")
private String title;

@NotEmpty
@Column(name = "content")
private String content;

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getTitle() {
    return title;
}

public void setTitle(String title) {
    this.title = title;
}

public String getContent() {
    return content;
}

public void setContent(String content) {
    this.content = content;
}

// public Usuarios getUser() {
//     return user;
// }

// public void setUser(Usuarios user) {
//     this.user = user;
// }

public Usuarios getUsuarios() {
    return user;
}

public void setUsuarios(Usuarios user) {
    this.user = user;
}

}
