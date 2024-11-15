package BookSwap.service.impl;

import BookSwap.model.dao.UsageDao;
import BookSwap.model.dao.UserDao;
import BookSwap.model.entity.Usage;
import BookSwap.model.entity.User;
import BookSwap.service.IUsage;
import BookSwap.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsageImpl implements IUsage {

    @Autowired
    private UsageDao usageDao;

    @Transactional
    public Usage save(Usage usage) {
        return usageDao.save(usage);
    }

    @Transactional(readOnly = true)
    public Usage findById(Integer id) {
        return usageDao.findById(id).orElse(null);
    }

    @Transactional
    public void delete(Usage usage) {
        usageDao.delete(usage);
    }

    @Transactional
    public List<Usage> findAll() {
        Iterable<Usage> usagesIterable = usageDao.findAll();
        List<Usage> usagesList = new ArrayList<>();
        usagesIterable.forEach(usagesList::add);
        return usagesList;
    }
}
