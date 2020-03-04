package de.schmidtdennis.popupchinese.data.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.schmidtdennis.popupchinese.data.dto.UserAccount;

@Repository
public interface UserRepository extends CrudRepository<UserAccount, Long> {
    
    List<UserAccount> findByName(String name);

    UserAccount findByEmail(String email);

    UserAccount findById(Integer id);

}