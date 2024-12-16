package com.desafio.service;

import com.desafio.dto.UserDTO;
import com.desafio.entity.UserEntity;
import com.desafio.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();

        // Converte cada UserEntity em UserDTO usando ModelMapper

        return userEntities.stream()
                .map(userEntity -> modelMapper.map(userEntity, UserDTO.class))
                .toList();
    }

    public UserDTO getUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        Assert.notNull(userEntity, "User not found");
        return modelMapper.map(userEntity, UserDTO.class);
    }

    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);

        int count = userRepository.countActiveUsers();

        if (userEntity.getActive()) {
            Assert.isTrue(count < 5, "Já existe 5 usuários ativos");
        }
        userEntity = userRepository.save(userEntity);
        return modelMapper.map(userEntity, UserDTO.class);
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        Assert.isTrue(id.equals(userDTO.getId()), "O ID não é o mesmo do usuário");

        UserEntity existingUser = userRepository.findById(id).orElse(null);
        Assert.notNull(existingUser, "User not found");


        // Verificar se o email foi alterado
        if (!existingUser.getEmail().equals(userDTO.getEmail())) {
            Optional<UserEntity> userWithEmail = userRepository.findByEmailAndIdNot(userDTO.getEmail(), id);
            if (userWithEmail.isPresent()) {
                throw new IllegalArgumentException("Email already registered.");
            }
        }
        if (!existingUser.getIsActive() && userDTO.getIsActive()) {
            int count = userRepository.countActiveUsers();
            Assert.isTrue(count < 5, "Já existe 5 usuários ativos");
        }

        UserEntity newUserEntity = modelMapper.map(userDTO, UserEntity.class);

        existingUser = userRepository.save(newUserEntity);

        return modelMapper.map(existingUser, UserDTO.class);
    }

    public String deleteUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);

        Assert.notNull(userEntity, "User not found");

        userRepository.delete(userEntity);

        return "Deletado com sucesso!";
    }

}
