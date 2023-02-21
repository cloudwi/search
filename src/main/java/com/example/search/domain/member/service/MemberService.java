package com.example.search.domain.member.service;

import com.example.search.domain.member.dto.MemberSaveRequestDto;
import com.example.search.domain.member.entity.Member;
import com.example.search.domain.member.repository.MemberRespository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

  private MemberRespository memberRespository;

  public MemberService(MemberRespository memberRespository) {
    this.memberRespository = memberRespository;
  }

  public Member save(MemberSaveRequestDto memberSaveRequestDto) {
    Member member = memberSaveRequestDto.toMember();
    return memberRespository.save(member);
  }
}
