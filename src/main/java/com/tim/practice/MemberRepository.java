package com.tim.practice;

import java.util.List;

public interface MemberRepository {
    void save(Member member);
    List<Member> findAll();
    boolean deleteByEmail(String email);
}