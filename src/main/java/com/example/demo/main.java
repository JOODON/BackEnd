package com.example.demo;

import Role.Role1;
import Role.Roledao1;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
    while (true) {
        System.out.println("--------------------");
        System.out.println("1.명함 입력");
        System.out.println("2.명함 검색");
        System.out.println("3.종료");
        System.out.println("--------------------");
        System.out.print("메뉴를 입력하세요 :  ");
        int number = in.nextInt();

        if (number == 1) {
            System.out.print("이름을 입력하세요 :");
            String name = in.next();
            System.out.print("전화번호를 입력하세요 :");
            String phonenumber = in.next();
            System.out.print("회사 이름을 입력하세요 :");
            String companyname = in.next();

            Role1 role1 = new Role1(name, phonenumber, companyname);

            Roledao1 dao = new Roledao1();

            int i = dao.addpost(role1);

            System.out.println("추가로 등록 되셨습니다");
        } else if (number == 2) {
            System.out.print("검색할 이름을 입력하세요 :  ");
            String Sname = in.next();
            Roledao1 dao = new Roledao1();
            String role1 = String.valueOf(dao.getpost(Sname));
            System.out.println(role1);
        }
        if (number == 3) {
            System.out.println("종료 되셨습니다");
            break;
        } else {
            System.out.println("잘못된 입력입니다");
        }
    }
    }
}
