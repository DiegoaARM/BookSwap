package BookSwap.service.impl;

import BookSwap.model.dao.NotificationDao;
import BookSwap.model.dao.Notification_templateDao;
import BookSwap.model.entity.Notification;
import BookSwap.model.entity.Notification_template;
import BookSwap.service.INotification;
import BookSwap.service.INotification_template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class Notification_templateImpl implements INotification_template {

    @Autowired
    private Notification_templateDao notification_templateDao;

    @Transactional
    public Notification_template save(Notification_template notification_template) {
        return notification_templateDao.save(notification_template);
    }

    @Transactional(readOnly = true)
    public Notification_template findById(Integer id) {
        return notification_templateDao.findById(id).orElse(null);
    }

    @Transactional
    public void delete(Notification_template notification_template) {
        notification_templateDao.delete(notification_template);
    }

    @Transactional
    public List<Notification_template> findAll() {
        Iterable<Notification_template> notification_templatesIterable = notification_templateDao.findAll();
        List<Notification_template> notification_templatesList = new ArrayList<>();
        notification_templatesIterable.forEach(notification_templatesList::add);
        return notification_templatesList;
    }
}
