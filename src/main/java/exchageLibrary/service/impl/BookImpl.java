package exchageLibrary.service.impl;

import exchageLibrary.model.dao.BookDao;
import exchageLibrary.model.entity.Book;
import exchageLibrary.model.entity.Genre;
import exchageLibrary.service.IBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BookImpl implements IBook {

    @Autowired
    private BookDao bookDao;

    @Override
    @Transactional
    public Book save(Book book) {
        return bookDao.save(book);
    }

    @Override
    @Transactional(readOnly = true)
    public Book findById(Integer id) {
        return bookDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Book book) {
        bookDao.delete(book);
    }

    @Override
    @Transactional
    public List<Book> findAll() {
        Iterable<Book> booksIterable = bookDao.findAll();
        List<Book> booksList = new ArrayList<>();
        booksIterable.forEach(booksList::add);
        return booksList;
    }

    @Override
    public List<Book> findByAuthor(Integer id_author) {
        Iterable<Book> booksIterable = bookDao.findAll();
        List<Book> booksList = new ArrayList<>();

        for (Book book : booksIterable) {
            if (book.getAuthor().getId() == (id_author)) {
                booksList.add(book);
            }
        }
        return booksList;
    }

    public List<Book> findByTitle(String title){
        Iterable<Book> booksIterable = bookDao.findAll();
        List<Book> booksList = new ArrayList<>();

        for (Book book : booksIterable) {
            if (Objects.equals(book.getTitle(), title)) {
                booksList.add(book);
            }
        }
        return booksList;
    }

    @Override
    public List<Book> findByGenre(Integer id_genre) {
        Iterable<Book> booksIterable = bookDao.findAll();
        List<Book> booksList = new ArrayList<>();

        for (Book book : booksIterable) {
            if (book.getGenresList().stream().anyMatch(genre -> genre.getId()==(id_genre))) {
                booksList.add(book);
            }
        }
        return booksList;
    }
}
