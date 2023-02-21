package com.example.search.domain.post.service;

import com.example.search.domain.member.entity.Member;
import com.example.search.domain.member.repository.MemberRespository;
import com.example.search.domain.post.dto.PostSaveRequestDto;
import com.example.search.domain.post.dto.PostSliceResponseDto;
import com.example.search.domain.post.entity.Post;
import com.example.search.domain.post.repository.PostRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
public class PostService {

  private final PostRepository postRepository;
  private final MemberRespository memberRespository;

  public PostService(PostRepository postRepository, MemberRespository memberRespository) {
    this.postRepository = postRepository;
    this.memberRespository = memberRespository;
  }

  public Post save(PostSaveRequestDto postSaveRequestDto) {

    Member member = memberRespository.findById(postSaveRequestDto.memberId())
        .orElseThrow(() -> new IllegalArgumentException("회원 조회해본결과 회원이 없습니다."));

    Post post = postSaveRequestDto.toEntity(member);
    return postRepository.save(post);
  }

  public Slice<PostSliceResponseDto> slice(String keyword, PageRequest pageRequest) {
    Slice<Post> posts = postRepository.findByTitleContaining(keyword, pageRequest);

    return posts.map(PostSliceResponseDto::toDto);
  }
}
