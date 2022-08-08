package com.example.demo;

import Role.Role;
import Role.Roledao;

import java.util.List;

public class Examjam3 {
    public static void main(String[] args) {
        Roledao dao = new Roledao();

        List<Role> list = dao.getRoles();
        for(Role role : list) {
            System.out.println(role);
        }
    }
}
