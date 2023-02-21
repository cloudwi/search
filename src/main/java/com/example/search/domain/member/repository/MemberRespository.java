package com.example.search.domain.member.repository;

import com.example.search.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRespository extends JpaRepository<Member, Long> {

}
