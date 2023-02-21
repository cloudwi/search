package com.example.search.domain.post.contorller;

import com.example.search.domain.post.dto.PostSaveRequestDto;
import com.example.search.domain.post.dto.PostSliceResponseDto;
import com.example.search.domain.post.entity.Post;
import com.example.search.domain.post.service.PostService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {

  private final PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  @PostMapping
  public Post save(@RequestBody PostSaveRequestDto postSaveRequestDto) {
    return postService.save(postSaveRequestDto);
  }

  @GetMapping
  public Slice<PostSliceResponseDto> findAll(@RequestParam(name = "page") int page,
  @RequestParam(name = "size") int size) {
    PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Direction.DESC, "id"));
    return postService.slice(pageRequest);
  }
}
