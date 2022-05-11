package com.example.controllers;

import com.example.entity.Admin;
import com.example.entity.Funcionario;
import com.example.entity.Login;
import com.example.entity.Medico;
import com.example.entity.Utente;
import com.example.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("username")
public class AdminController {

    @Autowired
    MedicoService medicoService;

    @Autowired
    EspecialidadeService especialidadeService;

    @Autowired
    FuncionarioService funcionarioService;

    @Autowired
    UtenteService utenteService;

    @Autowired
    AdminService adminService;

    @Autowired
    DisponibilidadeService disponibilidadeService;

    @Autowired
    ConsultasService consultasService;

    @Autowired
    LoginService loginService;


    @Autowired
    private PasswordEncoder passwordEncoder;

    // --------------------------------

    @GetMapping(value = "/admin_registo_medico")
    public String showRegistoMedico(ModelMap map) {
        map.put("medico", new Medico());
        map.put("especialidadeList", especialidadeService.getAllEspecialidade());
        return "admin_registo_medico";
    }

    @PostMapping(value = "/admin_registo_medico")
    public String registarUtente(@ModelAttribute Medico medico) {
        medico.setPassword(passwordEncoder.encode(medico.getPassword()));
        Login login = new Login();

        login.setPassword(medico.getPassword());
        login.setUsername(medico.getNome());
        login.setUsertype("medico");

        loginService.createLogin(login);
        medicoService.createMedico(medico);
        return "redirect:/admin_medicos";
    }

    // --------------------------------

    @GetMapping(value = "/admin_registo_funcionario")
    public String showRegistoFuncionario(ModelMap map) {
        map.put("funcionario", new Funcionario());
        return "admin_registo_funcionario";
    }

    @PostMapping(value = "/admin_registo_funcionario")
    public String registarFuncionario(@ModelAttribute Funcionario funcionario) {
        funcionario.setPassword(passwordEncoder.encode(funcionario.getPassword()));
        funcionarioService.createFuncionario(funcionario);

        Login login = new Login();

        login.setPassword(funcionario.getPassword());
        login.setUsername(funcionario.getNome());
        login.setUsertype("funcionario");

        loginService.createLogin(login);

        return "redirect:/admin_funcionario";
    }

    // --------------------------------

    @GetMapping(value = "/admin_consulta")
    public String showRegistoMedico23(ModelMap map) {

        map.put("consultaList", consultasService.getConsultas());

        return "admin_consulta";
    }

    @GetMapping(value = "/admin_consulta_details/{id}")
    public String showConsultaDetails(@PathVariable Long id, ModelMap map) {
        map.put("consulta", consultasService.getConsultaById(id));

        return "admin_consulta_details";
    }

    // --------------------------------

    @GetMapping(value = "/admin_contactos")
    public String showRegistoMedico24() {
        return "admin_contactos";
    }

    // --------------------------------

    @GetMapping(value = "/admin_funcionario")
    public String showRegistoMedico25(ModelMap map) {

        map.put("funcionariosList", funcionarioService.getAllFuncionario());

        return "admin_funcionario";
    }

    @PostMapping(value = "/admin_funcionario")
    public String deleteFuncionario(@RequestParam(name = "idFuncionario") Long idFuncionario) {
        Funcionario funcionarioDB = funcionarioService.getFuncionarioById(idFuncionario);

        funcionarioService.deleteFuncionario(funcionarioDB);

        return "redirect:/admin_funcionario";
    }

    // --------------------------------

    @GetMapping(value = "/admin_utente")
    public String showRegistoMedico30(ModelMap map) {

        map.put("utentesList", utenteService.getAllUtentes());

        return "admin_utente";
    }

    @PostMapping(value="/admin_utente")
    public String deleteUtente(@RequestParam(name = "idUtente") Long idUtente){
        Utente utenteDB = utenteService.getUtenteById(idUtente);
        utenteService.deleteUtente(utenteDB);

        return "redirect:/admin_utente";
    }

    @GetMapping(value = "/admin_utente_perfil/{id}")
    public String showUtentePage(@PathVariable Long id, ModelMap map) {
        map.put("utente", utenteService.getUtenteById(id));
        map.put("consultasList", consultasService.getConsultasByIdUtente(id));
        return "/admin_utente_perfil";
    }

    @GetMapping(value="/admin_medico_perfil/{id}")
    public String  showMedicoPage(@PathVariable Long id, ModelMap map) {
        map.put("medico", medicoService.getMedicoById(id));
        map.put("disponibilidadeList", disponibilidadeService.getAllDisponibilidadeByMedico(id));

        return "admin_medico_perfil";
    }


    // --------------------------------

    @GetMapping(value = "/admin_home")
    public String showRegistoMedico26(ModelMap map) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        map.put("username", username);

        map.put("medico", medicoService.countAllMedicos());
        map.put("funcionario", funcionarioService.countAllFuncionarios());
        map.put("utente", utenteService.countAllUtentes());
        return "admin_home";
    }

    // --------------------------------

    @GetMapping(value = "/admin_info_gerais")
    public String showRegistoMedico27() {
        return "admin_info_gerais";
    }

    // --------------------------------

    @GetMapping(value = "/admin_medicos")
    public String showRegistoMedico29(ModelMap map) {

        map.put("medicosList", medicoService.getAllMedicos());

        return "admin_medicos";
    }

    @PostMapping(value = "/admin_medicos")
    public String deleteMedico(@RequestParam(name = "idMedico") Long idMedico) {
        Medico medicoDB = medicoService.getMedicoById(idMedico);
        disponibilidadeService.deleteAllByMedico(medicoDB);
        medicoService.deleteMedico(medicoDB);
        return "redirect:/admin_medicos";
    }

    // --------------------------------

    @GetMapping(value = "/admin_perfil")
    public String showRegistoMedico298(ModelMap map) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        map.put("admin", adminService.getAllAdmins());//mapear a base de dados para o site
        return "admin_perfil";
    }

    // --------------------------------

    @GetMapping(value = "/admin_editar_perfil")
    public String a_editperfilPage(ModelMap map) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        map.put("admin", adminService.getAdminByNome(username));//mapear a base de dados para o site
        return "/admin_editar_perfil";
    }

    @PostMapping(value = "/admin_editar_perfil")
    public String updateAdmin(Admin admin, ModelMap map) {
        Admin adminDB = adminService.getAdminById(admin.getIdAdmin());
        adminDB.setTelemovel(admin.getTelemovel());
        adminDB.setLocalidade(admin.getLocalidade());
        adminDB.setAndar(admin.getAndar());
        adminDB.setCodigoPostal(admin.getCodigoPostal());
        adminDB.setEndereco(admin.getEndereco());
        adminService.updateAdmin(adminDB);
        map.put("admin", adminDB);
        return "redirect:/admin_perfil";
    }
}
