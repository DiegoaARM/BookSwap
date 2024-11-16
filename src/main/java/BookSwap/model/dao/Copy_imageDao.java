package BookSwap.model.dao;

import BookSwap.model.entity.Copy;
import BookSwap.model.entity.Copy_image;
import org.springframework.data.repository.CrudRepository;

public interface Copy_imageDao extends CrudRepository<Copy_image, Integer> {
}
