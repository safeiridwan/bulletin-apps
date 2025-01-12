package com.bulletin.app.repository;

import com.bulletin.app.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>, JpaSpecificationExecutor<Post> {
    List<Post> findAllByStatus(boolean status);
    Post findOneByIdAndStatus(Long id, boolean status);
    @Modifying
    @Query("UPDATE Post p SET p.viewers = p.viewers + 1 WHERE p.id = :id")
    int incrementViewers(Long id);
}
