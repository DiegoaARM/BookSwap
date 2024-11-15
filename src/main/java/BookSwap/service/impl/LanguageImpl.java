package BookSwap.service.impl;

import BookSwap.model.dao.LanguageDao;
import BookSwap.model.entity.Language;
import BookSwap.service.ILanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageImpl implements ILanguage {

    @Autowired
    private LanguageDao languageDao;

    @Transactional
    public Language save(Language language) {
        return languageDao.save(language);
    }

    @Transactional(readOnly = true)
    public Language findById(Integer id) {
        return languageDao.findById(id).orElse(null);
    }

    @Transactional
    public void delete(Language language) {
        languageDao.delete(language);
    }

    @Transactional
    public List<Language> findAll() {
        Iterable<Language> languagesIterable = languageDao.findAll();
        List<Language> languagesList = new ArrayList<>();
        languagesIterable.forEach(languagesList::add);
        return languagesList;
    }
}
