package exchageLibrary.model.dao;

import exchageLibrary.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {
}
