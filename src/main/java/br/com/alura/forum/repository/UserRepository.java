package br.com.alura.forum.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.modelo.User;

public interface UserRepository extends JpaRepository<User, Long> {

    // void save(User user) throws DataAccessException;
}
