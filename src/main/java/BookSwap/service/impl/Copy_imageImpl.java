package BookSwap.service.impl;

import BookSwap.model.dao.CopyDao;
import BookSwap.model.dao.Copy_imageDao;
import BookSwap.model.entity.Copy;
import BookSwap.model.entity.Copy_image;
import BookSwap.service.ICopy;
import BookSwap.service.ICopy_image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class Copy_imageImpl implements ICopy_image {

    @Autowired
    private Copy_imageDao copy_imageDao;

    @Override
    @Transactional
    public Copy_image save(Copy_image copy_image) {
        return copy_imageDao.save(copy_image);
    }

    @Override
    @Transactional(readOnly = true)
    public Copy_image findById(Integer id) {
        return copy_imageDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Copy_image copy_image) {
        copy_imageDao.delete(copy_image);
    }

    @Override
    @Transactional
    public List<Copy_image> findAll() {
        Iterable<Copy_image> copy_imagesIterable = copy_imageDao.findAll();
        List<Copy_image> copy_imagesList = new ArrayList<>();
        copy_imagesIterable.forEach(copy_imagesList::add);
        return copy_imagesList;
    }

}
