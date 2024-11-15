package BookSwap.service.impl;

import BookSwap.model.dao.ReviewDao;
import BookSwap.model.entity.Review;
import BookSwap.service.IReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewImpl implements IReview {

    @Autowired
    private ReviewDao reviewDao;

    @Transactional
    public Review save(Review review) {
        return reviewDao.save(review);
    }

    @Transactional(readOnly = true)
    public Review findById(Integer id) {
        return reviewDao.findById(id).orElse(null);
    }

    @Transactional
    public void delete(Review review) {
        reviewDao.delete(review);
    }

    @Transactional
    public List<Review> findAll() {
        Iterable<Review> reviewsIterable = reviewDao.findAll();
        List<Review> reviewsList = new ArrayList<>();
        reviewsIterable.forEach(reviewsList::add);
        return reviewsList;
    }
}
