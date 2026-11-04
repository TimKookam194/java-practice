package com.tim.practice;

import java.util.ArrayList;
import java.util.List;

public class InMemoryMemberRepository implements MemberRepository {
    private final List<Member> members = new ArrayList<>();

    @Override
    public void save(Member member) {
        members.add(member);
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(members);
    }

    @Override
    public boolean deleteByEmail(String email) {
        return members.removeIf(m -> m.getEmail().equalsIgnoreCase(email));
    }
}