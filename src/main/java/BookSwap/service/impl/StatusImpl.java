package BookSwap.service.impl;

import BookSwap.model.dao.NotificationDao;
import BookSwap.model.dao.StatusDao;
import BookSwap.model.entity.Notification;
import BookSwap.model.entity.Status;
import BookSwap.service.INotification;
import BookSwap.service.IStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusImpl implements IStatus {

    @Autowired
    private StatusDao statusDao;

    @Transactional
    public Status save(Status status) {
        return statusDao.save(status);
    }

    @Transactional(readOnly = true)
    public Status findById(Integer id) {
        return statusDao.findById(id).orElse(null);
    }

    @Transactional
    public void delete(Status status) {
        statusDao.delete(status);
    }

    @Transactional
    public List<Status> findAll() {
        Iterable<Status> statusIterable = statusDao.findAll();
        List<Status> statusList = new ArrayList<>();
        statusIterable.forEach(statusList::add);
        return statusList;
    }
}
