package BookSwap.model.dao;

import BookSwap.model.entity.Language;
import BookSwap.model.entity.Usage;
import org.springframework.data.repository.CrudRepository;

public interface LanguageDao extends CrudRepository<Language, Integer> {
}
