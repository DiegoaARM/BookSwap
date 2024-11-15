package BookSwap.service;

import BookSwap.model.entity.Notification;

import java.util.List;

public interface INotification {

    Notification save(Notification notification);

    Notification findById(Integer id);

    void delete(Notification notification);

    List<Notification> findAll();
}