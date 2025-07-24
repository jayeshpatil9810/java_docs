package poc.example.wishlist_module.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import poc.example.wishlist_module.entity.Wishlist;

@Repository
public interface Wishlistrepo extends JpaRepository<Wishlist, Long > {
 
	//void deleteById(Optional<Wishlist> product);
	//void deleteBypId(long pId);
	List<Wishlist> findByUserId(String userId);
	@Query("SELECT w FROM Wishlist w WHERE w.userId = :userId AND w.productId = :productId")
	Optional<Wishlist> findByUserIdAndPId(String userId, Long productId);
	
	void deleteByProductId(Long productId);
	 
	 
 }

