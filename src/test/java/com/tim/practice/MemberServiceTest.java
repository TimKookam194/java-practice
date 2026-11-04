package com.tim.practice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    @Test
    void addMemberShouldIncreaseCount() {
        MemberService service = new MemberService();
        service.add(new Member("Tim", "tim@mail.com", "0812345678"));
        assertEquals(1, service.count());
    }

    @Test
    void addDuplicateEmailShouldThrow() {
        MemberService service = new MemberService();
        service.add(new Member("Tim", "tim@mail.com", "0812345678"));
        assertThrows(IllegalArgumentException.class, () ->
                service.add(new Member("Tom", "tim@mail.com", "0899999999")));
    }
}