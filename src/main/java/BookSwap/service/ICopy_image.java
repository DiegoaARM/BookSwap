package BookSwap.service;

import BookSwap.model.entity.Copy;
import BookSwap.model.entity.Copy_image;

import java.util.List;

public interface ICopy_image {

    Copy_image save(Copy_image copy_image);

    Copy_image findById(Integer id);

    void delete(Copy_image copy_image);

    List<Copy_image> findAll();
}
