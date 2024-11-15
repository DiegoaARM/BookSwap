package BookSwap.model.dao;

import BookSwap.model.entity.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewDao extends CrudRepository<Review, Integer> {
}
