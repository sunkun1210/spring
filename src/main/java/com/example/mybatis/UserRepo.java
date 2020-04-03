package com.example.mybatis;

public interface UserRepo {
    @SKSql(value = "select * from user")
    void get();
}