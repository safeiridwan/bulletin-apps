package com.bulletin.app.repository;

import com.bulletin.app.entity.Post;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>, JpaSpecificationExecutor<Post> {
    @Query("SELECT p FROM Post p WHERE p.status = :status ORDER BY p.createdAt DESC")
    List<Post> findAllByStatusOrderByCreatedAtDesc(@Param("status") boolean status);

    Post findOneByIdAndStatus(Long id, boolean status);

    @Modifying
    @Query("UPDATE Post p SET p.viewers = p.viewers + 1 WHERE p.id = :id")
    int incrementViewers(Long id);

    @Query("SELECT MAX(p.sequence) FROM Post p")
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Long> findMaxSequence();
}
