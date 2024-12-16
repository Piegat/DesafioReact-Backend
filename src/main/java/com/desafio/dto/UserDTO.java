package com.desafio.dto;

import com.desafio.entity.RolesEnum;

public class UserDTO {

    private Long id;
    private String nome;
    private Boolean isActive;
    private String email;
    private String telefone;
    private String username;
    private RolesEnum role;
    private String senha;

    // Construtor com todos os campos
    public UserDTO(Long id, String nome, Boolean isActive, String email, String telefone, RolesEnum role, String senha) {
        this.id = id;
        this.nome = nome;
        this.isActive = isActive;
        this.email = email;
        this.telefone = telefone;
        this.role = role;
        this.senha = senha;
    }

    // Construtor sem argumentos (caso seja necessário)
    public UserDTO() {}

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", isActive=" + isActive +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", username = '" + username + '\'' +
                ", senha='" + senha + '\'' +
                ", telefone='" + telefone + '\'' +
                ", role=" + role +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter e Setter para nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter para isActive
    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    // Getter e Setter para email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter e Setter para telefone
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Getter e Setter para role
    public RolesEnum getRole() {
        return role;
    }

    public void setRole(RolesEnum role) {
        this.role = role;
    }

    // Getter e Setter para senha
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
