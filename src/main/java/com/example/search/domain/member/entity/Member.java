package com.example.search.domain.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "member_id")
  private Long id;
  @Column
  private String nickname;

  protected Member() {
  }

  public Member(String nickname) {
    this.nickname = nickname;
  }

  public Member(Long id, String nickname) {
    this.id = id;
    this.nickname = nickname;
  }

  public Long getId() {
    return id;
  }

  public String getNickname() {
    return nickname;
  }
}
