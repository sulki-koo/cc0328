package cookcloud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cookcloud.entity.Likes;

public interface LikesRepository extends JpaRepository<Likes, Long>{

	@Query("SELECT l FROM Likes l WHERE l.memId = :memId AND l.likeIsLiked = 'n'")
	List<Likes> findByMemId(@Param("memId") String memId);
	
}
