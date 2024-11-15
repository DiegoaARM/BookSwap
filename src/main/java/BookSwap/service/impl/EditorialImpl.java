package BookSwap.service.impl;

import BookSwap.model.dao.EditorialDao;
import BookSwap.model.entity.Editorial;
import BookSwap.service.IEditorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class EditorialImpl implements IEditorial {

    @Autowired
    private EditorialDao editorialDao;

    @Transactional
    public Editorial save(Editorial editorial) {
        return editorialDao.save(editorial);
    }

    @Transactional(readOnly = true)
    public Editorial findById(Integer id) {
        return editorialDao.findById(id).orElse(null);
    }

    @Transactional
    public void delete(Editorial editorial) {
        editorialDao.delete(editorial);
    }

    @Transactional
    public List<Editorial> findAll() {
        Iterable<Editorial> editorialsIterable = editorialDao.findAll();
        List<Editorial> editorialsList = new ArrayList<>();
        editorialsIterable.forEach(editorialsList::add);
        return editorialsList;
    }
}
