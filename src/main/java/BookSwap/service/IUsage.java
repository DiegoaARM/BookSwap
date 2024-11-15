package BookSwap.service;

import BookSwap.model.entity.Usage;
import BookSwap.model.entity.User;

import java.util.List;

public interface IUsage {

    Usage save(Usage usage);

    Usage findById(Integer id);

    void delete(Usage usage);

    List<Usage> findAll();
}
