package BookSwap.model.dao;

import BookSwap.model.entity.Notification;
import BookSwap.model.entity.Usage;
import org.springframework.data.repository.CrudRepository;

public interface NotificationDao extends CrudRepository<Notification, Integer> {
}
