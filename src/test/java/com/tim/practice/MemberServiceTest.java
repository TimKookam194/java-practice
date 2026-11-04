package com.tim.practice;
import java.util.List;

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
    @Test
    void findByNameShouldReturnMatchingMembers() {
        MemberService service = new MemberService();
        service.add(new Member("Tim", "tim@mail.com", "0812345678"));
        service.add(new Member("Tom", "tom@mail.com", "0899999999"));

        List<Member> result = service.findByName("tim");

        assertEquals(1, result.size());
        assertEquals("tim@mail.com", result.get(0).getEmail());
    }

    @Test
    void findByNameShouldReturnEmptyWhenNoMatch() {
        MemberService service = new MemberService();
        assertTrue(service.findByName("nobody").isEmpty());
    }
}