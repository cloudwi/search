package com.example.search.domain.post.repository.impl;

import static com.example.search.domain.member.entity.QMember.member;
import static com.example.search.domain.post.entity.QPost.post;

import com.example.search.domain.post.dto.PostSliceResponseDto;
import com.example.search.domain.post.entity.Post;
import com.example.search.domain.post.repository.querydsl.PostRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepositoryImpl extends QuerydslRepositorySupport implements PostRepositoryCustom {

  private static final long LAST_CHECK_NUM = 1L;

  private final JPAQueryFactory jpaQueryFactory;

  public PostRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
    super(Post.class);
    this.jpaQueryFactory = jpaQueryFactory;
  }

  @Override
  public Slice<PostSliceResponseDto> search(String keyword, PageRequest pageRequest) {
    List<Post> posts = jpaQueryFactory
        .select(post)
        .from(post)
        .join(post.member, member).fetchJoin()
        .where(post.title.eq(keyword))
        .offset(pageRequest.getOffset())
        .limit(pageRequest.getPageSize() + LAST_CHECK_NUM)
        .orderBy(post.id.desc())
        .fetch();

    List<PostSliceResponseDto> postSliceResponseDtos = new ArrayList<>();

    for (Post post : posts) {
      postSliceResponseDtos.add(PostSliceResponseDto.toDto(post));
    }

    boolean hasNext = false;
    if (postSliceResponseDtos.size() > pageRequest.getPageSize()) {
      postSliceResponseDtos.remove(pageRequest.getPageSize());
      hasNext = true;
    }

    return new SliceImpl<>(postSliceResponseDtos, pageRequest, hasNext);
  }
}
