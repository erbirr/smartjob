package com.smartjob.prueba.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void testGettersAndSetters() {
        User user = new User();

        // Verificar que los valores iniciales son nulos
        assertNull(user.getId());
        assertNull(user.getName());
        assertNull(user.getEmail());
        assertNull(user.getPassword());
        assertNull(user.getCreated());
        assertNull(user.getModified());
        assertNull(user.getLastLogin());
        assertNull(user.getToken());
        assertNull(user.getPhones());
        assertEquals(false, user.isActive());

        // Establecer valores
        UUID id = UUID.randomUUID();
        String name = "Juan Rodriguez";
        String email = "juan@rodriguez.org";
        String password = "hunter2";
        LocalDateTime created = LocalDateTime.now();
        LocalDateTime modified = LocalDateTime.now();
        LocalDateTime lastLogin = LocalDateTime.now();
        String token = "token123";
        boolean isActive = true;
        
        List<Phone> phones = new ArrayList<>();
        Phone phone = new Phone();
        phone.setNumber("1234567");
        phone.setCitycode("1");
        phone.setContrycode("57");
        phones.add(phone);

        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setCreated(created);
        user.setModified(modified);
        user.setLastLogin(lastLogin);
        user.setToken(token);
        user.setActive(isActive);
        user.setPhones(phones);

        // Verificar que los getters devuelven los valores correctos
        assertEquals(id, user.getId());
        assertEquals(name, user.getName());
        assertEquals(email, user.getEmail());
        assertEquals(password, user.getPassword());
        assertEquals(created, user.getCreated());
        assertEquals(modified, user.getModified());
        assertEquals(lastLogin, user.getLastLogin());
        assertEquals(token, user.getToken());
        assertEquals(isActive, user.isActive());
        assertEquals(phones, user.getPhones());
    }

    @Test
    void testConstructorAndFieldInitialization() {
        UUID id = UUID.randomUUID();
        String name = "Juan Rodriguez";
        String email = "juan@rodriguez.org";
        String password = "hunter2";
        LocalDateTime created = LocalDateTime.now();
        LocalDateTime modified = LocalDateTime.now();
        LocalDateTime lastLogin = LocalDateTime.now();
        String token = "token123";
        boolean isActive = true;

        List<Phone> phones = new ArrayList<>();
        Phone phone = new Phone();
        phone.setNumber("1234567");
        phone.setCitycode("1");
        phone.setContrycode("57");
        phones.add(phone);

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setCreated(created);
        user.setModified(modified);
        user.setLastLogin(lastLogin);
        user.setToken(token);
        user.setActive(isActive);
        user.setPhones(phones);

        assertEquals(id, user.getId());
        assertEquals(name, user.getName());
        assertEquals(email, user.getEmail());
        assertEquals(password, user.getPassword());
        assertEquals(created, user.getCreated());
        assertEquals(modified, user.getModified());
        assertEquals(lastLogin, user.getLastLogin());
        assertEquals(token, user.getToken());
        assertEquals(isActive, user.isActive());
        assertEquals(phones, user.getPhones());
    }
}

