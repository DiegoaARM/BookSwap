package BookSwap.service;

import BookSwap.model.entity.Request;
import BookSwap.model.entity.Usage;

import java.util.List;

public interface IRequest {

    Request save(Request request);

    Request findById(Integer id);

    void delete(Request request);

    List<Request> findAll();
}
