package com.example.controllers;

import com.example.entity.*;
import com.example.faturacao.FaturacaoService;
import com.example.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalTime;


@SessionAttributes("username")
@Controller
public class FunHomeController {

    @Autowired
    ConsultasService consultaService;

    @Autowired
    UtenteService utenteService;

    @Autowired
    MedicoService medicoService;

    @Autowired
    VagaService vagaService;

    @Autowired
    FuncionarioService funcionarioService;

    @Autowired
    ListaEsperaService listaEsperaService;

    @Autowired
    LoginService loginService;

    @Autowired
    DisponibilidadeService disponibilidadeService;

    @Autowired
    FaturacaoService faturacaoService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    // --------------------------------
    @GetMapping(value = "/fun_consulta")
    public String showCountriesPage(ModelMap map) {
        map.put("consultaList", consultaService.getConsultas()); //mapear a base de dados para o site
        ModelAndView mav = new ModelAndView("/fun_consulta"); // cria objecto que vai procurar na base de dados
        mav.addObject("procurar", new Procura());
        return "fun_consulta";
    }

    @PostMapping(value = {"/fun_consulta"})
    public String payInvoice (@RequestParam(name = "idFatura") String idFatura) {
        //Consulta consultaDB = consultaService.getConsultaById(idConsulta);
        faturacaoService.payInvoice(idFatura);


        return "redirect:/fun_consulta";
    }
// --------------------------------

    @GetMapping(value = "/fun_perfil")
    public String f_perfilPage(ModelMap map /*,@RequestParam(name = "username")String user */) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        map.put("funcionario", funcionarioService.getAllFuncionario());//mapear a base de dados para o site
        return "/fun_perfil";
    }

// --------------------------------

    @GetMapping(value = "/fun_editar_perfil")
    public String f_editperfilPage(ModelMap map) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        map.put("funcionario", funcionarioService.getFuncionarioByNome(username));//mapear a base de dados para o site
        return "/fun_editar_perfil";
    }

    @PostMapping(value = "/fun_editar_perfil")
    public String updateFuncionario(Funcionario funcionario, ModelMap map) {
        Funcionario funcionarioDB = funcionarioService.getFuncionarioById(funcionario.getIdFuncionario());
        funcionarioDB.setTelefone(funcionario.getTelefone());
        funcionarioDB.setTelemovel(funcionario.getTelemovel());
        funcionarioDB.setLocalidade(funcionario.getLocalidade());
        funcionarioDB.setAndar(funcionario.getAndar());
        funcionarioDB.setCodigoPostal(funcionario.getCodigoPostal());
        funcionarioDB.setMorada(funcionario.getMorada());
        map.put("funcionario", funcionarioDB);
        funcionarioService.updateFuncionario(funcionarioDB);
        return "redirect:/fun_perfil";
    }

    // --------------------------------
    @GetMapping(value = "/fun_home")
    public String f_loginPage(ModelMap map) {

        LocalTime horaAtual = LocalTime.now();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        map.put("username", username);
        map.put("atrasados", consultaService.atrasoConsulta(horaAtual));
        map.put("aguardar", listaEsperaService.countAllListaEspera());
        return "/fun_home";
    }

    @PostMapping(value = "/fun_home")
    public String checkInUtente(@RequestParam("idConsulta") Long id, ModelMap map) {
        LocalTime timestamp = LocalTime.now();
        System.out.println(timestamp);
        Consulta consultaDB = consultaService.getConsultaById(id);
        ListaEspera listaEspera = new ListaEspera();
        consultaDB.setEstado("Check-In");
        consultaDB.setListaEspera(listaEspera);
        listaEspera.setConsulta(consultaDB);
        listaEspera.setTimestamp(timestamp);
        listaEsperaService.createListaEspera(listaEspera);
        consultaService.updateConsulta(consultaDB);
        map.put("listaEspera", listaEsperaService.getAllListaEspera());
        return "redirect:/fun_lista_espera";
    }
// --------------------------------

    @GetMapping(value = "/fun_registo_utente")
    public String showRegistoUtente(ModelMap map) {
        map.put("utente", new Utente());
        return "fun_registo_utente";
    }

    @PostMapping(value = "/fun_registo_utente")
    public String registar_utente(@ModelAttribute Utente utente) {
        utente.setPassword(passwordEncoder.encode(utente.getPassword()));
        utenteService.createUtente(utente);
        Login login = new Login();

        login.setPassword(utente.getPassword());
        login.setUsername(utente.getNome());
        login.setUsertype("utente");

        loginService.createLogin(login);
        return "redirect:/fun_utentes";
    }
// --------------------------------

    @GetMapping(value = "/fun_utentes")
    public String f_utentesPage(ModelMap map) {
        map.put("utentesList", utenteService.getAllUtentes()); //mapear a base de dados para o site
        return "/fun_utentes";
    }

// --------------------------------

    @GetMapping(value = "/utente/{id}")
    public String showUtentePage(@PathVariable Long id, ModelMap map) {
        map.put("utente", utenteService.getUtenteById(id));
        map.put("consultasList", consultaService.getConsultasByIdUtente(id));
        return "/fun_perfil_utente";
    }
// --------------------------------

    @GetMapping(value = "/update-utente/{id}")
    public String showUtenteUpdatePage(@PathVariable Long id, ModelMap map) {
        map.put("utente", utenteService.getUtenteById(id));
        return "/editar_perfil_utente";
    }

    @PostMapping(value = "/update-utente/{id}")
    public String updateUtente(@PathVariable Long id, Utente utente, ModelMap map) {
        Utente utenteDB = utenteService.getUtenteById(id);
        utenteDB.setTelefone(utente.getTelefone());
        utenteDB.setTelemovel(utente.getTelemovel());
        utenteDB.setMorada(utente.getMorada());
        utenteDB.setCodigoPostal(utente.getCodigoPostal());
        utenteDB.setLocalidade(utente.getLocalidade());
        utenteDB.setObservacoes(utente.getObservacoes());
        utenteService.updateUtente(id, utenteDB);

        return "redirect:/utente/" + utenteDB.getIdUtente().toString();
    }

// --------------------------------
    // --------------------------------

    @GetMapping(value = "/fun_medicos")
    public String f_medicosPage(ModelMap map) {
        map.put("medicosList", medicoService.getAllMedicos()); //mapear a base de dados para o site
        return "/fun_medicos";
    }
    // --------------------------------

    @GetMapping(value = "/fun_perfil_medico/{id}")
    public String showMedicoPage(@PathVariable Long id, ModelMap map) {
        map.put("medico", medicoService.getMedicoById(id));
        map.put("disponibilidadeList", disponibilidadeService.getAllDisponibilidadeByMedico(id));
        return "fun_perfil_medico";
    }
    // --------------------------------


    @GetMapping(value = "/fun-nova-consulta/{id}")
    public String showNovaConsultaModal(@PathVariable Long id, ModelMap map) {
        Consulta consulta = new Consulta();
        map.put("consulta", consulta);
        map.put("utenteList", utenteService.getAllUtentes());
        map.put("vaga", vagaService.getVagaById(id));
        return "fun_nova_consulta";
    }

    @PostMapping(value = "/fun_registar_consulta/{id}")
    public String registar_consulta(@PathVariable Long id, Vaga vaga, @ModelAttribute Consulta consulta) {
        Vaga vagaDB = vagaService.getVagaById(id);
        vagaDB.setDisponivel(false);
        consulta.setEstado("Marcada");
        consulta.setVaga(vagaDB);
        consultaService.createConsulta(consulta);
        vagaService.updateVaga(id, vagaDB);
        return "redirect:/fun_consulta";
    }
    // --------------------------------

    @GetMapping(value = "/fun_consulta_details/{id}")
    public String detalhesConsulta(@PathVariable Long id, ModelMap map) {
        map.put("consulta", consultaService.getConsultaById(id));

        return "/fun_consulta_details";
    }

    @PostMapping(value="/fun_consulta_details/{id}")
    public String detalhesConsultaCheckIn(@PathVariable Long id){
        Consulta consultaDB = consultaService.getConsultaById(id);

        String path = null;

        if (consultaDB.getEstado().equals("Check-In") || consultaDB.getEstado().equals("Realizada") || consultaDB.getEstado().equals("Cancelada")) {
            path = "redirect:/fun_consulta_details/" + consultaDB.getIdConsulta().toString();
        } else if (consultaDB.getEstado().equals("Marcada")){
            LocalTime timestamp = LocalTime.now();
            System.out.println(timestamp);
            ListaEspera listaEspera = new ListaEspera();
            consultaDB.setEstado("Check-In");
            consultaDB.setListaEspera(listaEspera);
            listaEspera.setConsulta(consultaDB);
            listaEspera.setTimestamp(timestamp);
            listaEsperaService.createListaEspera(listaEspera);
            consultaService.updateConsulta(consultaDB);
            path = "redirect:/fun_lista_espera";
        }

        return path;
    }

    @PostMapping(value = "/fun_cancelar_consulta/{id}")
    public String detalhesConsultaCancelar (@PathVariable Long id) {
        Consulta consultaDB = consultaService.getConsultaById(id);
        Vaga vagaDB = vagaService.getVagaById(consultaDB.getVaga().getId());

        String path = null;

        if (consultaDB.getEstado().equals("Realizada") || consultaDB.getEstado().equals("Cancelada")) {
            path = "redirect:/fun_consulta_details/" + consultaDB.getIdConsulta().toString();
        } else {
            consultaDB.setEstado("Cancelada");
            vagaDB.setDisponivel(true);
            consultaDB.setVaga(null);
            vagaService.updateVaga(vagaDB);
            consultaService.updateConsulta(consultaDB);
            path = "redirect:/fun_consulta";
        }

        return path;
    }

    // --------------------------------

    @DeleteMapping(value = "/delete-consulta/{id}")
    public String deleteConsulta(@PathVariable Long id, @ModelAttribute Consulta consulta) {
        consultaService.deleteConsulta(id);
        return "redirect:/fun_consulta";
    }

    // --------------------------------

    // --------------------------------

    @GetMapping(value = "/fun_nova_consulta")
    public String showNovaConsulta() {
        return "fun_nova_consulta";
    }

    // --------------------------------

    @GetMapping(value = "/fun_lista_espera")
    public String f_listaEsperaPage(ModelMap map) {
        LocalTime horaAtual = LocalTime.now();
        map.put("listaEspera", listaEsperaService.getAllListaEspera());
        map.put("atrasados", consultaService.atrasoConsulta(horaAtual));
        map.put("aguardar", listaEsperaService.countAllListaEspera());

        return "fun_lista_espera";
    }
    // --------------------------------

    @GetMapping(value = "/fun_info_gerais")
    public String f_infogeraisPage() {
        return "/fun_info_gerais";
    }

    // --------------------------------
    @GetMapping(value = "/fun_contactos")
    public String f_contactosPage() {
        return "fun_contactos";
    }
}