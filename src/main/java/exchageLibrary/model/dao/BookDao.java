package exchageLibrary.model.dao;

import exchageLibrary.model.entity.Book;
import exchageLibrary.model.entity.Copy;
import org.springframework.data.repository.CrudRepository;

public interface BookDao extends CrudRepository<Book, Integer> {
}
