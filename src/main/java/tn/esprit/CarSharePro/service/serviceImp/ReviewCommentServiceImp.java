package tn.esprit.CarSharePro.service.serviceImp;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.CarSharePro.entity.Review;
import tn.esprit.CarSharePro.entity.ReviewComment;
import tn.esprit.CarSharePro.repository.ReviewCommentRepository;
import tn.esprit.CarSharePro.service.IReviewCommentService;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ReviewCommentServiceImp implements IReviewCommentService {

    ReviewCommentRepository repository;

    @Override
    public List<ReviewComment> getAllReviewComments() {
        return repository.findAll();
    }

    @Override
    public ReviewComment getReviewCommentById(Long idReviewComment) {
        return repository.findById(idReviewComment).orElse(null);
    }

    @Override
    public ReviewComment createReviewComment(ReviewComment reviewComment) {
        return repository.save(reviewComment);
    }

    @Override
    public ReviewComment updateReviewComment(ReviewComment reviewComment) {
      return repository.save(reviewComment);
    }

    @Override
    public void deleteReviewComment(Long id) {repository.deleteById(id);}

    @Override
    public List<ReviewComment> getReviewCommentsByVehicleId(Long vehicleId) {
        return repository.findByVehicleId(vehicleId);
    }

    @Override
    public List<ReviewComment> getReviewCommentsByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public long countCommentsByVehicleId(Long vehicleId) {
        return repository.countByVehicleId(vehicleId);

    }

    @Override
    public long countCommentsByUserId(Long userId) {
        return repository.countByUserId(userId);
    }

    @Override
    public List<ReviewComment> searchCommentsByKeyword(String keyword) {
        return repository.findByTextContaining(keyword);
    }

    @Override
    public Map<Review, Long> countReviewsByTypeAndVehicleId(Long vehicleId) {
        return repository.countReviewsByTypeAndVehicleId(vehicleId);
    }
}

