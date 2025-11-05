package org.commandpattern.commands.repositories;

import org.commandpattern.commands.entities.Light;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LightRepository extends JpaRepository<Light, Long> {
    Optional<Light> findByDescription(String description);
}
