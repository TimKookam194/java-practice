package com.tim.practice;

import java.util.ArrayList;
import java.util.List;

public class MemberService {
    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    // ให้โค้ดเดิมที่เรียก new MemberService() ยังใช้ได้
    public MemberService() {
        this(new InMemoryMemberRepository());
    }

    public void add(Member member) {
        validate(member);
        for (Member m : repository.findAll()) {
            if (m.getEmail().equalsIgnoreCase(member.getEmail())) {
                throw new IllegalArgumentException("อีเมลนี้มีอยู่แล้ว");
            }
        }
        repository.save(member);
    }

    public int count() {
        return repository.findAll().size();
    }

    public List<Member> findByName(String keyword) {
        List<Member> result = new ArrayList<>();
        for (Member m : repository.findAll()) {
            if (m.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(m);
            }
        }
        return result;
    }

    public boolean removeByEmail(String email) {
        return repository.deleteByEmail(email);
    }

    public boolean updatePhone(String email, String newPhone) {
        for (Member m : repository.findAll()) {
            if (m.getEmail().equalsIgnoreCase(email)) {
                m.setPhone(newPhone);
                return true;
            }
        }
        return false;
    }

    private void validate(Member member) {
        if (member.getName() == null || member.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("ชื่อห้ามว่าง");
        }
        if (member.getEmail() == null || !member.getEmail().contains("@")) {
            throw new IllegalArgumentException("รูปแบบอีเมลไม่ถูกต้อง");
        }
        if (member.getPhone() == null || !member.getPhone().matches("\\d{9,10}")) {
            throw new IllegalArgumentException("เบอร์โทรต้องเป็นตัวเลข 9-10 หลัก");
        }
    }
}