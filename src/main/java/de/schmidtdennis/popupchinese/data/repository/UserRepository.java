package de.schmidtdennis.popupchinese.data.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import de.schmidtdennis.popupchinese.data.dto.User;

public interface UserRepository extends CrudRepository<User, Long> {
    
    List<User> findByName(String name);

    User findById(long id);

}