package com.example.search.domain.post.dto;

import com.example.search.domain.post.entity.Post;

public record PostSliceResponseDto(
    Long postId,
    String title,
    String content,
    String nickname
) {

  public static PostSliceResponseDto toDto(Post post) {
    return new PostSliceResponseDto(post.getId(), post.getTitle(), post.getContent(), post.getMember().getNickname());
  }
}
