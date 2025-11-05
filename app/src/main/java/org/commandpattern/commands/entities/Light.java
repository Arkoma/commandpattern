package org.commandpattern.commands.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "lights")
public class Light {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
    private String description;

    public Light(String description) {
        this.description = description;
    }

    public Light() {

    }

    public void on() {
        this.status = "ON";
    }

    public void off() {
        this.status = "OFF";
    }

    public String getStatus() {
        return status;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
