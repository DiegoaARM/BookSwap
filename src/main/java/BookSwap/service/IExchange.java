package BookSwap.service;

import BookSwap.model.entity.Exchange;

import java.util.List;

public interface IExchange {

    Exchange save(Exchange exchange);

    Exchange findById(Integer id);

    void delete(Exchange exchange);

    List<Exchange> findAll();
}
