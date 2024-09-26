package BookSwap.model.dao;

import BookSwap.model.entity.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreDao extends CrudRepository<Genre, Integer> {
}
