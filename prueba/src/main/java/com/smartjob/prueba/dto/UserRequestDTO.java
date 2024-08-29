package com.smartjob.prueba.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserRequestDTO {
    @NotBlank(message = "El nombre es obligatorio")
    private String name;
    
    @Email(message = "Formato del email es inválido")
    //@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z]{2,6}$", message = "Formato del email es inválido")
    private String email;
    
    //La contraseña puede tener cualquier caracter con una longitud mínima de 6 caracterez.
    @Pattern(regexp = "^.{6,}$", message = "El formato de password es inválido")
    private String password;

    @Valid
    private List<PhoneDTO> phones;

    // Getters y setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PhoneDTO> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneDTO> phones) {
        this.phones = phones;
    }
}
