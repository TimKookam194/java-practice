package com.tim.practice;
import java.util.List;

import javax.xml.crypto.dsig.dom.DOMValidateContext;

import java.security.cert.CertPathValidatorException;
import java.util.ArrayList;


public class MemberService {
    private final List<Member> members = new ArrayList<>();

    public void add(Member member) {
         validate(member);
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
    public boolean removeByEmail(String email) {
        return members.removeIf(m -> m.getEmail().equalsIgnoreCase(email));
    }

    public boolean updatePhone(String email, String newPhone) {
        for (Member m : members) {
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