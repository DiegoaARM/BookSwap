package BookSwap.service;

import BookSwap.model.entity.Notification_template;

import java.util.List;

public interface INotification_template {

    Notification_template save(Notification_template notification_template);

    Notification_template findById(Integer id);

    void delete(Notification_template notification_template);

    List<Notification_template> findAll();
}