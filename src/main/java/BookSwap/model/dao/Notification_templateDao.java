package BookSwap.model.dao;

import BookSwap.model.entity.Notification_template;
import BookSwap.model.entity.Usage;
import org.springframework.data.repository.CrudRepository;

public interface Notification_templateDao extends CrudRepository<Notification_template, Integer> {
}
