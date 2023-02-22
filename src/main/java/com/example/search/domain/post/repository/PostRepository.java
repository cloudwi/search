package com.example.search.domain.post.repository;

import com.example.search.domain.post.entity.Post;
import com.example.search.domain.post.repository.querydsl.PostRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom {
}
