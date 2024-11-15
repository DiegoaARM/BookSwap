package BookSwap.service;

import BookSwap.model.entity.Editorial;

import java.util.List;

public interface IEditorial {

    Editorial save(Editorial editorial);

    Editorial findById(Integer id);

    void delete(Editorial editorial);

    List<Editorial> findAll();
}
