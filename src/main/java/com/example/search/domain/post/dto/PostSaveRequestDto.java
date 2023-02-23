package com.example.search.domain.post.dto;

import com.example.search.domain.member.entity.Member;
import com.example.search.domain.post.entity.Post;

public record PostSaveRequestDto(
    String title,
    String content,
    Long memberId
) {

  public Post toEntity(Member member) {
    return new Post(this.title, this.content, member);
  }
}
