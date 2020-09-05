package com.siscondominio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "articles")

public class Articles {
    
    public Articles () {

    }

    public Articles(String title, String content) {
        super();
        this.title = title;
        this.content = content;
    }

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

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

}
