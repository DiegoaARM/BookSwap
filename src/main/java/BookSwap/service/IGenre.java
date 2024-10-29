package BookSwap.service;

import BookSwap.model.entity.Genre;

import java.util.List;

public interface IGenre {

    Genre findById(Integer id);

    List<Genre> findAll();

    List<Genre> findGenresWithBooks();
}
