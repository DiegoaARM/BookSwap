package BookSwap.model.dao;

import BookSwap.model.entity.Request;
import BookSwap.model.entity.Usage;
import org.springframework.data.repository.CrudRepository;

public interface RequestDao extends CrudRepository<Request, Integer> {
}
