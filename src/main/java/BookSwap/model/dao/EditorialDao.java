package BookSwap.model.dao;

import BookSwap.model.entity.Editorial;
import BookSwap.model.entity.Usage;
import org.springframework.data.repository.CrudRepository;

public interface EditorialDao extends CrudRepository<Editorial, Integer> {
}
