package BookSwap.model.dao;

import BookSwap.model.entity.City;
import BookSwap.model.entity.Usage;
import org.springframework.data.repository.CrudRepository;

public interface CityDao extends CrudRepository<City, Integer> {
}
