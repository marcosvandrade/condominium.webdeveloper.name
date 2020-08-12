package com.siscondominio.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")

public class Usuarios extends AbstractEntity {
    private static final long serialVersionUID = 1L;
 
     public Usuarios() {
        
     }
    
    @Column(name = "email") //username
    private String email; // TODO --> verificar se no banco estah como unique key

    @Column(name = "senha")
    // @JsonIgnore
    private String senha;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "apartamento")
    private String apartamento;

    @Column(name = "contato1")
    private String contato1;

    @Column(name = "contato2")
    private String contato2;

    @Column(name = "nome")
    private String nome;

    /**
     * Voce pode optar por usar o pacote “java.sql.*” que possui as classes Date,
     * Time e Timestamp, onde estas representam respectivamente Data, Hora e Data
     * Hora juntos, sendo assim voce nao precisara usar a anotação @Temporal.
     */
    @Column(name = "data_acesso")
    private Date data_acesso;

    @Column(name = "data_cadastro")
    private Date data_cadastro;
    
    @Column(name = "arquivado")
    private Boolean arquivado;

    @Column(name = "administrador")
    private Boolean administrador;

    @Column(name = "bloqueado")
    private Boolean bloqueado;
   
    // public Integer getId() {
    //     return id;
    // }

    // public void setId(Integer id) {
    //     this.id = id;
    // }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public String getContato1() {
        return contato1;
    }

    public void setContato1(String contato1) {
        this.contato1 = contato1;
    }

    public String getContato2() {
        return contato2;
    }

    public void setContato2(String contato2) {
        this.contato2 = contato2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_acesso() {
        return data_acesso;
    }

    public void setData_acesso(Date data_acesso) {
        this.data_acesso = data_acesso;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getArquivado() {
        return arquivado;
    }

    public void setArquivado(Boolean arquivado) {
        this.arquivado = arquivado;
    }

    public Boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }

    public Boolean getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(Boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    //  @Override
    //  public String toString() {
    //      return "Usuarios [administrador=" + administrador + ", apartamento=" + apartamento + ", arquivado=" + arquivado
    //              + ", bloqueado=" + bloqueado + ", contato1=" + contato1 + ", contato2=" + contato2 + ", data_acesso="
    //              + data_acesso + ", data_cadastro=" + data_cadastro + ", email=" + email + ", id=" + id + ", nome="
    //              + nome + ", senha=" + senha + "]";
    //  }
    
}