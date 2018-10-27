package com.group19.comment.g19_comment.repository;

import com.group19.comment.g19_comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource
public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByRestaurants_Rid(Long rid);

    @Query("SELECT ROUND(AVG(c.rating),2) FROM Comment c WHERE c.restaurants.rid = :id")
    List<Comment> findAllRating(@Param("id") Long rid);

}
