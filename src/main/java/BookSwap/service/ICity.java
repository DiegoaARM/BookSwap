package BookSwap.service;

import BookSwap.model.entity.City;
import BookSwap.model.entity.Usage;

import java.util.List;

public interface ICity {

    City save(City city);

    City findById(Integer id);

    void delete(City city);

    List<City> findAll();
}
