package BookSwap.service.impl;

import BookSwap.model.dao.CopyDao;
import BookSwap.model.entity.Copy;
import BookSwap.service.ICopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CopyImpl implements ICopy {

    @Autowired
    private CopyDao copyDao;

    @Override
    @Transactional
    public Copy save(Copy copy) {
        return copyDao.save(copy);
    }

    @Override
    @Transactional(readOnly = true)
    public Copy findById(Integer id) {
        return copyDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Copy copy) {
        copyDao.delete(copy);
    }

    @Override
    @Transactional
    public List<Copy> findAll() {
        Iterable<Copy> copiesIterable = copyDao.findAll();
        List<Copy> copiesList = new ArrayList<>();
        copiesIterable.forEach(copiesList::add);
        return copiesList;
    }

    @Override
    public List<Copy> findByBook(Integer id_book) {
        Iterable<Copy> copiesIterable = copyDao.findAll();
        List<Copy> copiesList = new ArrayList<>();

        for (Copy copy : copiesIterable) {
            if (copy.getBook().getId() == (id_book)) {
                copiesList.add(copy);
            }
        }
        return copiesList;
    }

    @Override
    public List<Copy> findByUser(String id_user) {
        Iterable<Copy> copiesIterable = copyDao.findAll();
        List<Copy> copiesList = new ArrayList<>();

        for (Copy copy : copiesIterable) {
            if (Objects.equals(copy.getUser().getId(), id_user)) {
                copiesList.add(copy);
            }
        }
        return copiesList;
    }


}
