package com.example.search.domain.post.repository;

import com.example.search.domain.post.entity.Post;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

  @Query(value = "select p from Post p join fetch p.member where p.title like %?1%")
  Slice<Post> findByTitleContaining(String keyword,PageRequest pageRequest);
}
