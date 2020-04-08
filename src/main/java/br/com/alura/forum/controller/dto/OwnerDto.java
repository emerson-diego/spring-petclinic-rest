package br.com.alura.forum.controller.dto;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import br.com.alura.forum.modelo.Owner;
import br.com.alura.forum.modelo.Person;
import br.com.alura.forum.modelo.Pet;

public class OwnerDto extends Person {

    private Long id;
    private String address;
    private String city;
    private String telephone;
    private Set<PetDto> pets = new HashSet();

    public OwnerDto() {

    }

    public OwnerDto(Owner owner) {
        super(owner.getFirstName(), owner.getLastName());
        this.id = owner.getId();
        this.address = owner.getAddress();
        this.city = owner.getCity();
        this.telephone = owner.getTelephone();

        for (Pet pet : owner.getPets()) {
            PetDto petDto = new PetDto(pet);
            this.pets.add(petDto);
        }
        // this.pets = owner.getPets();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<PetDto> getPets() {
        return pets;
    }

    public void setPets(Set<PetDto> pets) {
        this.pets = pets;
    }

    public static Collection<OwnerDto> converter(Collection<Owner> owners) {
        return owners.stream().map(OwnerDto::new).collect(Collectors.toList());
        // return owners.map(OwnerDto::new);
    }

}
