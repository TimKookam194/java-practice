package com.tim.practice;

public class Member {
    private final String name;
    private final String email;
    private  String phone;

    public Member(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    
    public void setPhone(String phone) { this.phone = phone; }
}