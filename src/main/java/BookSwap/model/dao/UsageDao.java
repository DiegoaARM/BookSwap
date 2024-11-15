package BookSwap.model.dao;

import BookSwap.model.entity.Usage;
import BookSwap.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UsageDao extends CrudRepository<Usage, Integer> {
}
