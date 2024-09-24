package exchageLibrary.model.dao;

import exchageLibrary.model.entity.Copy;
import exchageLibrary.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface CopyDao extends CrudRepository<Copy, Integer> {
}
