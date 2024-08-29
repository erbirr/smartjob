package com.smartjob.prueba.repository;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.smartjob.prueba.model.User;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindByEmail() {
        // Crear y guardar un nuevo usuario
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setName("Juan Rodriguez");
        user.setEmail("juan@rodriguez.org");
        user.setPassword("hunter2");
        userRepository.save(user);

        // Buscar por email
        Optional<User> foundUser = userRepository.findByEmail("juan@rodriguez.org");

        // Verificar que el usuario fue encontrado y que sus datos coinciden
        assertTrue(foundUser.isPresent());
        assertEquals("Juan Rodriguez", foundUser.get().getName());
        assertEquals("juan@rodriguez.org", foundUser.get().getEmail());
    }

    @Test
    void testFindByEmailNotFound() {
        // Buscar por un email que no existe
        Optional<User> foundUser = userRepository.findByEmail("noexiste@correo.com");

        // Verificar que no se encontró ningún usuario
        assertTrue(foundUser.isEmpty());
    }

    @Test
    void testSaveAndRetrieveUser() {
        // Crear y guardar un nuevo usuario
        User user = new User();
        // user.setId(UUID.randomUUID());  // Deja que la base de datos asigne el ID
        user.setName("Maria Lopez");
        user.setEmail("maria@lopez.com");
        user.setPassword("securepassword");
        userRepository.save(user);
    
        assertNotNull(user.getId());  // Verificar que el ID ha sido asignado
    
        // Recuperar el usuario por ID
        Optional<User> foundUser = userRepository.findById(user.getId());
    
        // Verificar que el usuario fue encontrado y que sus datos coinciden
        assertTrue(foundUser.isPresent());
        assertEquals("Maria Lopez", foundUser.get().getName());
        assertEquals("maria@lopez.com", foundUser.get().getEmail());
    }
    
}
