package com.smartjob.prueba.model;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PhoneTest {

    @Test
    void testGettersAndSetters() {
        Phone phone = new Phone();

        // Verificar que los valores iniciales son nulos
        assertNull(phone.getId());
        assertNull(phone.getNumber());
        assertNull(phone.getCitycode());
        assertNull(phone.getContrycode());

        // Establecer valores
        Long id = 1L;
        String number = "1234567";
        String citycode = "1";
        String contrycode = "57";

        phone.setId(id);
        phone.setNumber(number);
        phone.setCitycode(citycode);
        phone.setContrycode(contrycode);

        // Verificar que los getters devuelven los valores correctos
        assertEquals(id, phone.getId());
        assertEquals(number, phone.getNumber());
        assertEquals(citycode, phone.getCitycode());
        assertEquals(contrycode, phone.getContrycode());
    }

    @Test
    void testConstructorAndFieldInitialization() {
        Long id = 2L;
        String number = "9876543";
        String citycode = "2";
        String contrycode = "34";

        Phone phone = new Phone();
        phone.setId(id);
        phone.setNumber(number);
        phone.setCitycode(citycode);
        phone.setContrycode(contrycode);

        assertEquals(id, phone.getId());
        assertEquals(number, phone.getNumber());
        assertEquals(citycode, phone.getCitycode());
        assertEquals(contrycode, phone.getContrycode());
    }
}

