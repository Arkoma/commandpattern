package org.commandpattern;

import org.commandpattern.commands.entities.Light;
import org.commandpattern.commands.implementations.LightOnCommand;
import org.commandpattern.commands.repositories.LightRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
class SimpleRemoteControlTest {

    @Autowired
    private LightRepository lightRepository;

    @AfterEach
    void tearDown() {
        lightRepository.deleteAll();
    }

    @Test
    void turnALightOn() {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light("My Light");
        LightOnCommand command = new LightOnCommand(lightRepository, light);

        remote.setCommand(command);
        assertNull(light.getStatus());
        remote.buttonWasPressed();

        Optional<Light> saved = lightRepository.findByDescription("My Light");
        assertTrue(saved.isPresent());
        assertEquals("ON", saved.get().getStatus());

    }

}