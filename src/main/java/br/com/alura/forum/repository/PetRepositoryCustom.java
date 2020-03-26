package br.com.alura.forum.repository;

import java.util.List;

import br.com.alura.forum.modelo.PetType;

public interface PetRepositoryCustom {

    public List<PetType> findPetTypes();
}