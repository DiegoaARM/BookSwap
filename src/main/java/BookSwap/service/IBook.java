package BookSwap.service;

import BookSwap.model.entity.Book;

import java.util.List;

public interface IBook {

    Book save(Book book);

    Book findById(Integer id);

    void delete(Book book);

    List<Book> findAll();

    List<Book> findByAuthor(Integer id_author);

    List<Book> findByTitle(String title);

    List<Book> findByGenre(Integer id_genre);
}
