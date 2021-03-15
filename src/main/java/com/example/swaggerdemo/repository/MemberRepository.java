package com.example.swaggerdemo.repository;

import com.example.swaggerdemo.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
