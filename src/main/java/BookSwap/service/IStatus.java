package BookSwap.service;

import BookSwap.model.entity.Status;

import java.util.List;

public interface IStatus {

    Status save(Status status);

    Status findById(Integer id);

    void delete(Status status);

    List<Status> findAll();
}
