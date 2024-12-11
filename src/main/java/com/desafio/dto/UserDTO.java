package com.desafio.dto;

import com.desafio.entity.RolesEnum;

public record UserDTO(
        Long id,
        String nome,
        String email,
        String telefone,
        RolesEnum role
) {}