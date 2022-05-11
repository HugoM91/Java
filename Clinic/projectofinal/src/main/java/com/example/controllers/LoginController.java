package com.example.controllers;

import com.example.entity.Login;
import com.example.services.LoginService;
import org.apache.tomcat.util.buf.B2CConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("username")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping(value = {"/login", "/"})
    public String loginPage() {
        ModelAndView mav = new ModelAndView("/login");
        mav.addObject("Submit", new Login());
        return "login";
    }


    @PostMapping(value = {"/login"})
    public ModelAndView loginClicked(@ModelAttribute("/login") Login login/*,ModelMap model*/) {
        String isValidUser = loginService.validateLogin(login, "username");
        System.out.println("user  que passa : " + isValidUser);
        ModelAndView mav;
        //model.put("username", login.getUsername());
        System.out.println(login.getUsername());
        if (isValidUser.equals("funcionario")) {
            mav = new ModelAndView("/fun_home");
            mav.addObject("username", login.getUsername());
            return mav;
        } else if (isValidUser.equals("utente")) {
            mav = new ModelAndView("/ute_home");
            mav.addObject("username", login.getUsername());
            return mav;
        } else if (isValidUser.equals("medico")) {
            mav = new ModelAndView("/med_home");
            mav.addObject("username", login.getUsername());
            return mav;
        } else if (isValidUser.equals("admin")) {
            mav = new ModelAndView("/admin_home");
            mav.addObject("username", login.getUsername());
            return mav;
        } else {
            mav = new ModelAndView("/login");
            return mav;
        }
    }
}
/*
    @PostMapping(value = {"/fun_login"})
    public String loginClicked (@ModelAttribute ("/fun_login") Login login){
        boolean isValidUser = loginService.validateLogin(login);
        ModelAndView mav;
        if(isValidUser){
            mav = new ModelAndView("/" + login.getUsername()+"/fun_home");
            System.out.println(login.getUsername());
            return "fun_home";
        }else{
            mav = new ModelAndView("login");
            mav.addObject("errorMessage" , "Invalid Credentials");
        }
        System.out.println("ola");
        return "fun_login";
    }
*/