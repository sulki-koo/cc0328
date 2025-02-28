package cookcloud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cookcloud.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{
	
	@Query("SELECT r FROM Review r WHERE r.memId = :memId AND r.reviewIsDeleted = 'n' ORDER BY r.reviewId DESC")
	List<Review> findByMemId(String memId);
	
	@Query("SELECT r FROM Review r WHERE r.recipeId = :recipeId AND r.reviewIsDeleted = 'n' ORDER BY r.reviewId DESC")
	List<Review> findByRecipeId(Long recipeId);
	
}
