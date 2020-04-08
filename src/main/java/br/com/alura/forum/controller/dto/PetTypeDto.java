package br.com.alura.forum.controller.dto;

import br.com.alura.forum.modelo.PetType;

public class PetTypeDto {

    private Long id;
    private String name;

    public PetTypeDto() {
    }

    public PetTypeDto(PetType petType) {
        this.id = petType.getId();
        this.name = petType.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
