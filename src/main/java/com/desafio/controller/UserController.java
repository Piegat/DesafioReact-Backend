package com.desafio.controller;

import com.desafio.dto.UserDTO;
import com.desafio.entity.RolesEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/all")
    public UserDTO getAllUsers() {
        try{
            return new UserDTO(1L, "teste1", true, "gustavo@gmail.com", "45998026871", RolesEnum.ADMIN, "password");
        }catch (Exception e){
            System.out.println("Deu pau");
            return null;
        }
    }
}
