package com.siscondominio.dto;

import java.io.Serializable;

import com.siscondominio.model.Articles;

public class ArticlesDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Integer id;
	private String title;
	private String content;
	
	public ArticlesDTO() {
	}

	public ArticlesDTO(Articles obj) {
		id = obj.getId();
		title = obj.getTitle();
		content = obj.getContent();
    }

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
