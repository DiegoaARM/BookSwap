package BookSwap.service.impl;

import BookSwap.model.dao.RequestDao;
import BookSwap.model.entity.Request;
import BookSwap.service.IRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RequestImpl implements IRequest {

    @Autowired
    private RequestDao requestDao;

    @Transactional
    public Request save(Request request) {
        return requestDao.save(request);
    }

    @Transactional(readOnly = true)
    public Request findById(Integer id) {
        return requestDao.findById(id).orElse(null);
    }

    @Transactional
    public void delete(Request request) {
        requestDao.delete(request);
    }

    @Transactional
    public List<Request> findAll() {
        Iterable<Request> requestsIterable = requestDao.findAll();
        List<Request> requestsList = new ArrayList<>();
        requestsIterable.forEach(requestsList::add);
        return requestsList;
    }
}
