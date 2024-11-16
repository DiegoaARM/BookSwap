package BookSwap.service.impl;

import BookSwap.fireBase.FirebaseStorageService;
import BookSwap.model.dao.CopyDao;
import BookSwap.model.entity.Copy;
import BookSwap.model.entity.Copy_image;
import BookSwap.service.ICopy;
import BookSwap.service.ICopy_image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class CopyImpl implements ICopy {

    @Autowired
    private CopyDao copyDao;

    @Autowired
    private ICopy_image copyImageService;

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @Override
    @Transactional
    public Copy save(Copy copy) {
        if (copy.getCreated_at() == null) {
            copy.setCreated_at(new Date());
        }
        if (copy.getImagesList() != null) {
            copy.getImagesList().forEach(image -> image.setCopy(copy));
        }
        return copyDao.save(copy);
    }

    @Override
    @Transactional(readOnly = true)
    public Copy findById(Integer id) {
        return copyDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Copy copy) {
        if (copy.getImagesList() != null) {
            for (Copy_image image : copy.getImagesList()) {
                if (image.getPicture() != null &&
                        image.getPicture().contains("firebase")) {
                    try {
                        firebaseStorageService.deleteFile(image.getPicture());
                    } catch (Exception e) {
                        // Log el error pero continúa con el borrado
                        System.err.println("Error deleting image from Firebase: " + e.getMessage());
                    }
                }
            }
        }
        // Luego borrar el registro de la base de datos
        copyDao.delete(copy);
    }
    @Override
    @Transactional
    public List<Copy> findAll() {
        Iterable<Copy> copiesIterable = copyDao.findAll();
        List<Copy> copiesList = new ArrayList<>();
        copiesIterable.forEach(copiesList::add);
        return copiesList;
    }

    @Override
    public List<Copy> findByBook(Integer id_book) {
        Iterable<Copy> copiesIterable = copyDao.findAll();
        List<Copy> copiesList = new ArrayList<>();

        for (Copy copy : copiesIterable) {
            if (copy.getBook().getId() == (id_book)) {
                copiesList.add(copy);
            }
        }
        return copiesList;
    }

    @Override
    public List<Copy> findByUser(String id_user) {
        Iterable<Copy> copiesIterable = copyDao.findAll();
        List<Copy> copiesList = new ArrayList<>();

        for (Copy copy : copiesIterable) {
            if (Objects.equals(copy.getUser().getId(), id_user)) {
                copiesList.add(copy);
            }
        }
        return copiesList;
    }


}
