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
  private String nickName;

  protected Member() {
  }

  public Member(String nickName) {
    this.nickName = nickName;
  }

  public Member(Long id, String nickName) {
    this.id = id;
    this.nickName = nickName;
  }

  public Long getId() {
    return id;
  }

  public String getNickName() {
    return nickName;
  }
}
