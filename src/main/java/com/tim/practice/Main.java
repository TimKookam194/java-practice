package com.tim.practice;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MemberService service = new MemberService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== ระบบจัดการสมาชิก ===");
            System.out.println("1. เพิ่มสมาชิก");
            System.out.println("2. ค้นหาจากชื่อ");
            System.out.println("3. แก้ไขเบอร์โทร");
            System.out.println("4. ลบสมาชิก");
            System.out.println("0. ออก");
            System.out.print("เลือก: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("ชื่อ: ");
                    String name = scanner.nextLine();
                    System.out.print("อีเมล: ");
                    String email = scanner.nextLine();
                    System.out.print("เบอร์โทร: ");
                    String phone = scanner.nextLine();
                    try {
                        service.add(new Member(name, email, phone));
                        System.out.println("เพิ่มสมาชิกเรียบร้อย");
                    } catch (IllegalArgumentException e) {
                        System.out.println("ผิดพลาด: " + e.getMessage());
                    }
                    break;
                case "2":
                    System.out.print("คำค้นหา: ");
                    List<Member> found = service.findByName(scanner.nextLine());
                    if (found.isEmpty()) {
                        System.out.println("ไม่พบสมาชิก");
                    }
                    for (Member m : found) {
                        System.out.println(m.getName() + " | " + m.getEmail() + " | " + m.getPhone());
                    }
                    break;
                case "3":
                    System.out.print("อีเมลสมาชิก: ");
                    String emailToUpdate = scanner.nextLine();
                    System.out.print("เบอร์โทรใหม่: ");
                    String newPhone = scanner.nextLine();
                    System.out.println(service.updatePhone(emailToUpdate, newPhone)
                            ? "แก้ไขเรียบร้อย" : "ไม่พบสมาชิก");
                    break;
                case "4":
                    System.out.print("อีเมลสมาชิกที่ต้องการลบ: ");
                    System.out.println(service.removeByEmail(scanner.nextLine())
                            ? "ลบเรียบร้อย" : "ไม่พบสมาชิก");
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("เมนูไม่ถูกต้อง");
            }
        }
        scanner.close();
    }
}