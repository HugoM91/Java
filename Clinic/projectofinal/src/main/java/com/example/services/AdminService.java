package com.example.services;

import com.example.entity.Admin;

import java.util.List;

public interface AdminService {

    List<Admin> getAllAdmins();

    Admin getAdminById(Long id);

    Admin getAdminByNome(String nome);

    void createAdmin(Admin admin);

    void updateAdmin(Admin admin);

    void deleteAdmin(Long id);

    long countAllAdmin();
}
