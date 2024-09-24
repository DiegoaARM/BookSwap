package exchageLibrary.service;

import exchageLibrary.model.entity.Genre;
import exchageLibrary.model.entity.User;

import java.util.List;

public interface IGenre {

    Genre findById(Integer id);

    List<Genre> findAll();
}
