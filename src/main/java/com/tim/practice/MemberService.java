package com.tim.practice;

import java.util.ArrayList;
import java.util.List;

public class MemberService {
    private final List<Member> members = new ArrayList<>();

    public void add(Member member) {
        for (Member m : members) {
            if (m.getEmail().equalsIgnoreCase(member.getEmail())) {
                throw new IllegalArgumentException("อีเมลนี้มีอยู่แล้ว");
            }
        }
        members.add(member);
    }

    public int count() {
        return members.size();
    }
}