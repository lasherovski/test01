package com.group19.comment.g19_comment.repository;

import com.group19.comment.g19_comment.entity.Comment;
import com.group19.comment.g19_comment.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource
public interface RatingRepository extends JpaRepository<Rating,Long> {


}
