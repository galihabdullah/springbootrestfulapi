package com.sporthubid.repository;

import com.sporthubid.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;


@RestResource (exported = false)

public interface PostRepository extends JpaRepository<Post, Integer> {
}
