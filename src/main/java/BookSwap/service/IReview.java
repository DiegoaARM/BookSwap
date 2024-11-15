package BookSwap.service;

import BookSwap.model.entity.Review;
import BookSwap.model.entity.Usage;

import java.util.List;

public interface IReview {

    Review save(Review review);

    Review findById(Integer id);

    void delete(Review review);

    List<Review> findAll();
}
