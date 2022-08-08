package com.example.demo;

import Role.Role;
import Role.Roledao;

public class Examjam2 {
    public static void main(String[] args) {
        int roleID=4;
        String description="ROle Four";

        Role role = new Role(roleID,description);

        Roledao dao=new Roledao();

        int insertCount=dao.addRole(role);

        System.out.println("추가 등록 되셨습니다.");
    }
}
