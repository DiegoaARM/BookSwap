package exchageLibrary.model.dao;

import exchageLibrary.model.entity.Copy;
import exchageLibrary.model.entity.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreDao extends CrudRepository<Genre, Integer> {
}
