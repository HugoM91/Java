package com.example.services;


import com.example.entity.Login;


public interface LoginService {
    String validateLogin(Login login, String what);

    void createLogin(Login login);

}
