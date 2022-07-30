package com.example.demo;

import Role.Role;
import Role.Roledao;

public class Examjam {
    public static void main(String[] args) {
        Roledao dao=new Roledao();
        Role role=dao.getRole(1);
        System.out.println(role);
    }
}
