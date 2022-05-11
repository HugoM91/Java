package com.example.services;

import com.example.entity.Login;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;


@Service
public class MyUserDetails implements UserDetails {

    private String userName;

    public MyUserDetails(String userName) {
        this.userName = userName;
    }

    public MyUserDetails() {
    }

    //--------------
    public String validateLogin2(String username, String what) {
        try {
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/teste_upskill?useTimezone=true&serverTimezone=UTC";
            Class.forName(myDriver);

            Connection conn = DriverManager.getConnection(myUrl, "root","");

            String query = "SELECT * FROM login WHERE username LIKE '" + username + "' ";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String password = rs.getString("password");
                String usertype = rs.getString("usertype");
                if (what.equals("password")) {
                    return password;
                } else if (what.equals("usertype")) {
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

    //--------
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(validateLogin2(userName, "usertype")));
    }

    @Override
    public String getPassword() {
        return validateLogin2(userName, "password");
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
