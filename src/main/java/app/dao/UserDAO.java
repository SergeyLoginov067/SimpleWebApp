package app.dao;

import app.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserDAO extends CrudRepository<User, Long> {

    Optional<User> findByLogin(String login);

}
