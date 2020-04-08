package br.com.alura.forum.controller.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import br.com.alura.forum.modelo.Pet;
import br.com.alura.forum.modelo.Visit;

public class PetDto {

    private Long id;
    private String name;
    private Date birthDate;
    private PetTypeDto type;
    private Long owner;
    private Set<VisitDto> visits = new HashSet();

    public PetDto() {
    }

    public PetDto(Pet pet) {
        this.id = pet.getId();
        this.name = pet.getName();
        this.birthDate = pet.getBirthDate();
        this.type = new PetTypeDto(pet.getType());
        this.owner = pet.getOwner().getId();
        for (Visit visit : pet.getVisits()) {
            VisitDto visitDto = new VisitDto(visit);
            this.visits.add(visitDto);
        }

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public PetTypeDto getType() {
        return type;
    }

    public void setType(PetTypeDto type) {
        this.type = type;
    }

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }

    public Set<VisitDto> getVisits() {
        return visits;
    }

    public void setVisits(Set<VisitDto> visits) {
        this.visits = visits;
    }

}
