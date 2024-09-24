package exchageLibrary.service;

import exchageLibrary.model.entity.Copy;
import exchageLibrary.model.entity.User;

import java.util.List;

public interface ICopy {

    Copy save(Copy copy);

    Copy findById(Integer id);

    void delete(Copy copy);

    List<Copy> findAll();

    List<Copy> findByBook(Integer id_book);

    List<Copy> findByUser(Integer id_user);
}
