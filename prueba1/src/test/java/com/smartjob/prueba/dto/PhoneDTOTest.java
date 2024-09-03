package com.smartjob.prueba.dto;

import static org.junit.jupiter.api.Assertions.*;

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

class PhoneDTOTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void whenAllFieldsAreValid_thenNoConstraintViolations() {
        PhoneDTO phoneDTO = new PhoneDTO();
        phoneDTO.setNumber("1234567");
        phoneDTO.setCitycode("1");
        phoneDTO.setContrycode("57");

        Set<ConstraintViolation<PhoneDTO>> violations = validator.validate(phoneDTO);

        assertTrue(violations.isEmpty());
    }

    @Test
    void whenNumberIsBlank_thenOneConstraintViolation() {
        PhoneDTO phoneDTO = new PhoneDTO();
        phoneDTO.setNumber("");
        phoneDTO.setCitycode("1");
        phoneDTO.setContrycode("57");

        Set<ConstraintViolation<PhoneDTO>> violations = validator.validate(phoneDTO);

        assertEquals(1, violations.size());
        assertEquals("El número de telefono es obligatorio", violations.iterator().next().getMessage());
    }

    @Test
    void whenCitycodeIsBlank_thenOneConstraintViolation() {
        PhoneDTO phoneDTO = new PhoneDTO();
        phoneDTO.setNumber("1234567");
        phoneDTO.setCitycode("");
        phoneDTO.setContrycode("57");

        Set<ConstraintViolation<PhoneDTO>> violations = validator.validate(phoneDTO);

        assertEquals(1, violations.size());
        assertEquals("El código de ciudad es obligatorio", violations.iterator().next().getMessage());
    }

    @Test
    void whenContrycodeIsBlank_thenOneConstraintViolation() {
        PhoneDTO phoneDTO = new PhoneDTO();
        phoneDTO.setNumber("1234567");
        phoneDTO.setCitycode("1");
        phoneDTO.setContrycode("");

        Set<ConstraintViolation<PhoneDTO>> violations = validator.validate(phoneDTO);

        assertEquals(1, violations.size());
        assertEquals("El código de país es obligatorio", violations.iterator().next().getMessage());
    }
}
