package BookSwap.service.impl;

import BookSwap.model.dao.NotificationDao;
import BookSwap.model.dao.UsageDao;
import BookSwap.model.entity.Notification;
import BookSwap.model.entity.Usage;
import BookSwap.service.INotification;
import BookSwap.service.IUsage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationImpl implements INotification {

    @Autowired
    private NotificationDao notificationDao;

    @Transactional
    public Notification save(Notification notification) {
        return notificationDao.save(notification);
    }

    @Transactional(readOnly = true)
    public Notification findById(Integer id) {
        return notificationDao.findById(id).orElse(null);
    }

    @Transactional
    public void delete(Notification notification) {
        notificationDao.delete(notification);
    }

    @Transactional
    public List<Notification> findAll() {
        Iterable<Notification> notificationsIterable = notificationDao.findAll();
        List<Notification> notificationsList = new ArrayList<>();
        notificationsIterable.forEach(notificationsList::add);
        return notificationsList;
    }
}
