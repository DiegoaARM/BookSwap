package exchageLibrary.controller;

import exchageLibrary.model.entity.Copy;
import exchageLibrary.model.entity.Genre;
import exchageLibrary.service.IGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class GenreController {

    @Autowired
    private IGenre genreService;

    @GetMapping(path = "genre/{id}")
    public Genre findById(@PathVariable Integer id) {
        return genreService.findById(id);
    }

    @GetMapping(path = "genres")
    public List<Genre> findAll(){
        return genreService.findAll();
    }

}
