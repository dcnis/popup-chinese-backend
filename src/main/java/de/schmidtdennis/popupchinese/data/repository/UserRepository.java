package de.schmidtdennis.popupchinese.data.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import de.schmidtdennis.popupchinese.data.dto.UserAccount;

public interface UserRepository extends CrudRepository<UserAccount, Long> {
    
    List<UserAccount> findByName(String name);

    UserAccount findById(long id);

}