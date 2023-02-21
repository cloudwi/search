package com.example.search.domain.member.dto;

import com.example.search.domain.member.entity.Member;

public record MemberSaveRequestDto(
    String nickname
) {

  public Member toMember() {
    return new Member(this.nickname);
  }
}
