package com.desafio.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    private Long id;

    private Boolean isActive;

    private String nome;

    private String email;

    private String senha;

    private String telefone;

    private RolesEnum role;
}
