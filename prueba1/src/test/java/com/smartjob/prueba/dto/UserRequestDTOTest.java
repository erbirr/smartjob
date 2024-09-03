package com.smartjob.prueba.dto;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;*/

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserRequestDTOTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void whenAllFieldsAreValid_thenNoConstraintViolations() {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setName("Juan Rodriguez");
        userRequestDTO.setEmail("juan@rodriguez.org");
        userRequestDTO.setPassword("hunter2");

        List<PhoneDTO> phones = new ArrayList<>();
        PhoneDTO phoneDTO = new PhoneDTO();
        phoneDTO.setNumber("1234567");
        phoneDTO.setCitycode("1");
        phoneDTO.setContrycode("57");
        phones.add(phoneDTO);

        userRequestDTO.setPhones(phones);

        Set<ConstraintViolation<UserRequestDTO>> violations = validator.validate(userRequestDTO);

        assertTrue(violations.isEmpty());
    }

    @Test
    void whenNameIsBlank_thenOneConstraintViolation() {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setName("");  // Nombre en blanco
        userRequestDTO.setEmail("juan@rodriguez.org");
        userRequestDTO.setPassword("hunter2");

        Set<ConstraintViolation<UserRequestDTO>> violations = validator.validate(userRequestDTO);

        assertEquals(1, violations.size());
        assertEquals("El nombre es obligatorio", violations.iterator().next().getMessage());
    }

    @Test
    void whenEmailIsInvalid_thenNoConstraintViolation() {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setName("Juan Rodriguez");
        userRequestDTO.setEmail("juan@rodriguez");  // Este valor puede ser considerado válido con @Email
    
        Set<ConstraintViolation<UserRequestDTO>> violations = validator.validate(userRequestDTO);
    
        assertTrue(violations.isEmpty());
    }
    

    @Test
    void whenPasswordIsInvalid_thenOneConstraintViolation() {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setName("Juan Rodriguez");
        userRequestDTO.setEmail("juan@rodriguez.org");
        userRequestDTO.setPassword("abc");  // Contraseña inválida (menos de 6 caracteres)

        Set<ConstraintViolation<UserRequestDTO>> violations = validator.validate(userRequestDTO);

        assertEquals(1, violations.size());
        assertEquals("El formato de password es inválido", violations.iterator().next().getMessage());
    }

    @Test
    void whenPhonesAreInvalid_thenOneConstraintViolation() {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setName("Juan Rodriguez");
        userRequestDTO.setEmail("juan@rodriguez.org");
        userRequestDTO.setPassword("hunter2");

        List<PhoneDTO> phones = new ArrayList<>();
        PhoneDTO phoneDTO = new PhoneDTO();
        phoneDTO.setNumber("");  // Número de teléfono inválido
        phoneDTO.setCitycode("1");
        phoneDTO.setContrycode("57");
        phones.add(phoneDTO);

        userRequestDTO.setPhones(phones);

        Set<ConstraintViolation<UserRequestDTO>> violations = validator.validate(userRequestDTO);

        assertEquals(1, violations.size());
        assertEquals("El número de telefono es obligatorio", violations.iterator().next().getMessage());
    }
}
