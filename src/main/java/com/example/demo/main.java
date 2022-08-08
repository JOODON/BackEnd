package com.example.demo;

import Role.Role1;
import Role.Roledao1;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        System.out.println("--------------------");
        System.out.println("1.명함 입력");
        System.out.println("2.명함 검색");
        System.out.println("3.종료");
        System.out.println("--------------------");
        System.out.print("메뉴를 입력하세요 :  ");
        int number = in.nextInt();

        if(number == 1){
            System.out.println("이름을 입력하세요 :");
            String name=in.next();
            System.out.println("전화번호를 입력하세요 :");
            String phonenumber=in.next();
            System.out.println("회사 이름을 입력하세요 :");
            String companyname=in.next();

            Role1 role1=new Role1(name,phonenumber,companyname);

            Roledao1 dao=new Roledao1();

            int i=dao.addpost(role1);

            System.out.println(i);

        }
    }
}
