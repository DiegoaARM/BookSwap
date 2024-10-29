package BookSwap.service;

import BookSwap.model.entity.Copy;

import java.util.List;

public interface ICopy {

    Copy save(Copy copy);

    Copy findById(Integer id);

    void delete(Copy copy);

    List<Copy> findAll();

    List<Copy> findByBook(Integer id_book);

    List<Copy> findByUser(String id_user);
}
