package com.example.search.domain.member.controller;

import com.example.search.domain.member.dto.MemberSaveRequestDto;
import com.example.search.domain.member.entity.Member;
import com.example.search.domain.member.service.MemberService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
public class MemberController {

  private final MemberService memberService;

  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  @PostMapping
  public Member save(@RequestBody MemberSaveRequestDto memberSaveRequestDto) {
    return memberService.save(memberSaveRequestDto);
  }
}
