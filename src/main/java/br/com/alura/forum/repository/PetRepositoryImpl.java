package br.com.alura.forum.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

import br.com.alura.forum.modelo.PetType;

@Repository
@Transactional(readOnly = true)
public class PetRepositoryImpl implements PetRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<PetType> findPetTypes() {
        return this.entityManager.createQuery("SELECT ptype FROM PetType ptype ORDER BY ptype.name").getResultList();
    }

}