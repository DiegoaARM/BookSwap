package BookSwap.model.dao;

import BookSwap.model.entity.Status;
import BookSwap.model.entity.Usage;
import org.springframework.data.repository.CrudRepository;

public interface StatusDao extends CrudRepository<Status, Integer> {
}
