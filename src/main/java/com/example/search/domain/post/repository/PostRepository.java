package com.example.search.domain.post.repository;

import com.example.search.domain.post.entity.Post;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {


  Slice<Post> findSliceBy(PageRequest pageRequest);
}
