package com.example.services;

import com.example.entity.Login;
import com.example.entity.Medico;
import com.example.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepository loginRepository;

    @Override

    public String validateLogin(Login login, String what) {
        try {
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/teste_upskill?useTimezone=true&serverTimezone=UTC";
            Class.forName(myDriver);

            Connection conn = DriverManager.getConnection(myUrl, "root", "");


            String query = "SELECT * FROM login";
            if (what.equals("username")) {
                query = "SELECT * FROM login WHERE username LIKE '" + login.getUsername() + "' ";
            }

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String password = rs.getString("password");
                String usertype = rs.getString("usertype");
                if (password.equals(login.getPassword())) {
                    return usertype;
                }
            }
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return "false";
    }

    @Override
    public void createLogin(Login login) {
        this.loginRepository.save(login);
    }
}