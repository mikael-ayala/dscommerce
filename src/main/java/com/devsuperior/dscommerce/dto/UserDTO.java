package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Role;
import com.devsuperior.dscommerce.entities.User;

import java.time.LocalDate;
import java.util.List;

public record UserDTO(
        Long id,
        String name,
        String email,
        String phone,
        LocalDate birthDate,
        List<String> roles
) {
    public UserDTO(User entity) {
        this(entity.getId(),
            entity.getName(),
            entity.getEmail(),
            entity.getPhone(),
            entity.getBirthDate(),
            entity.getRoles().stream().map(Role::getAuthority).toList());
    }
}
