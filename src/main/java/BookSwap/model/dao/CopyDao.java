package BookSwap.model.dao;

import BookSwap.model.entity.Copy;
import org.springframework.data.repository.CrudRepository;

public interface CopyDao extends CrudRepository<Copy, Integer> {
}
