package com.smartjob.prueba.service;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartjob.prueba.dto.UserRequestDTO;
import com.smartjob.prueba.model.Phone;
import com.smartjob.prueba.model.User;
import com.smartjob.prueba.repository.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    public User registerUser(UserRequestDTO userRequestDTO) {
        // Validar si el correo ya existe
        if (userRepository.findByEmail(userRequestDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException("El email ya se encuentra registrado");
        }

        // Mapear DTO a entidad
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        user.setPhones(userRequestDTO.getPhones().stream().map(phoneDTO -> {
            Phone phone = new Phone();
            phone.setNumber(phoneDTO.getNumber());
            phone.setCitycode(phoneDTO.getCitycode());
            phone.setContrycode(phoneDTO.getContrycode());
            return phone;
        }).collect(Collectors.toList()));
        user.setCreated(LocalDateTime.now());
        user.setModified(LocalDateTime.now());
        user.setLastLogin(LocalDateTime.now());
        user.setToken(generateToken(user));
        user.setActive(true);

        return userRepository.save(user);
    }

    public String generateToken(User user) {
        
        return Jwts.builder()
                .setSubject(user.getEmail())
                .signWith(key) // Usa el objeto Key en lugar de una cadena
                .compact();

    }

    
}