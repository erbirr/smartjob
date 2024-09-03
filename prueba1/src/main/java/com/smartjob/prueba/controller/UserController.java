package com.smartjob.prueba.controller;

import java.util.Collections;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartjob.prueba.dto.UserRequestDTO;
import com.smartjob.prueba.exception.EmailAlreadyRegisteredException;
import com.smartjob.prueba.exception.TokenGenerationException;
import com.smartjob.prueba.model.User;
import com.smartjob.prueba.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
//import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
@Api(tags = "Administración de usuarios") // Anotación de Swagger para describir el controlador
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ApiOperation(value = "Registrar un nuevo usuario", notes = "Este endpoint registra un nuevo usuario en el sistema.")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        User user = userService.registerUser(userRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @ExceptionHandler(EmailAlreadyRegisteredException.class)
    public ResponseEntity<Object> handleEmailAlreadyRegisteredException(EmailAlreadyRegisteredException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap("mensaje", ex.getMessage()));
    }


    @ExceptionHandler(TokenGenerationException.class)
    public ResponseEntity<Object> handleTokenGenerationException(TokenGenerationException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Collections.singletonMap("mensaje", ex.getMessage()));
    }

}
