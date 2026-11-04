package com.tim.practice;
import java.util.List;

import java.util.ArrayList;


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
    public List<Member> findByName(String keyword) {
        List<Member> result = new ArrayList<>();
        for (Member m : members) {
            if (m.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(m);
            }
        }
        return result;
    }
}