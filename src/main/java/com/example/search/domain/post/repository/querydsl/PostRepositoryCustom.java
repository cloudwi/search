package com.example.search.domain.post.repository.querydsl;

import com.example.search.domain.post.dto.PostSliceResponseDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;

public interface PostRepositoryCustom {

  Slice<PostSliceResponseDto> search(String keyword, PageRequest pageRequest);
}
