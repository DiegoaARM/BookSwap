package BookSwap.service.impl;

import BookSwap.model.dao.CityDao;
import BookSwap.model.entity.City;
import BookSwap.model.entity.Usage;
import BookSwap.service.ICity;
import BookSwap.service.IUsage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityImpl implements ICity {

    @Autowired
    private CityDao cityDao;

    @Transactional
    public City save(City city) {
        return cityDao.save(city);
    }

    @Transactional(readOnly = true)
    public City findById(Integer id) {
        return cityDao.findById(id).orElse(null);
    }

    @Transactional
    public void delete(City city) {
        cityDao.delete(city);
    }

    @Transactional
    public List<City> findAll() {
        Iterable<City> citiesIterable = cityDao.findAll();
        List<City> citiesList = new ArrayList<>();
        citiesIterable.forEach(citiesList::add);
        return citiesList;
    }
}
