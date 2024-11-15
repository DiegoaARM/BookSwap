package BookSwap.service;

import BookSwap.model.entity.Language;
import BookSwap.model.entity.Usage;

import java.util.List;

public interface ILanguage {

    Language save(Language language);

    Language findById(Integer id);

    void delete(Language language);

    List<Language> findAll();
}
