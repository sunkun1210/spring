package com.example.mybatis;

public interface UserRepo2 {
    @SKSql(value = "select * from user2")
    void get();
}