package org.commandpattern.commands.implementations;

import org.commandpattern.commands.Command;
import org.commandpattern.commands.entities.Light;
import org.commandpattern.commands.repositories.LightRepository;

public record LightOnCommand(LightRepository lightRepository, Light light) implements Command {

    @Override
    public void execute() {
        light.on();
        this.lightRepository.save(light);
    }
}
