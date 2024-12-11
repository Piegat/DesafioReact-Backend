package com.desafio.dto;

import com.desafio.entity.RolesEnum;

public record UserCreateUpdateDTO(
        String nome,
        String email,
        String telefone,
        RolesEnum role,
        String senha
) {}
