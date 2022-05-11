package com.example.controllers;

import com.example.entity.*;
import com.example.faturacao.CreateInvoiceRequest;
import com.example.faturacao.FaturacaoService;
import com.example.services.ConsultasService;
import com.example.services.ListaEsperaService;
import com.example.services.MedicoService;
import com.example.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.time.LocalTime;

@SessionAttributes("username")
@Controller
public class MedicoController {

    long idEmergencia;

    @Autowired
    private ListaEsperaService listaEsperaService;

    @Autowired
    private ConsultasService consultasService;

    @Autowired
    private MedicoService medicosService;

    @Autowired
    private FaturacaoService faturacaoService;

    @Autowired
    private UtenteService utenteService;
    // --------------------------------


    @GetMapping(value = "/med_consulta_iniciada")
    public String showOngoingConsulta(ModelMap map) {
        map.put("consulta", consultasService.getConsultaById(idEmergencia));
        return "med_ongoing_consulta";
    }

    @PostMapping(value = "med_consulta_iniciada")
    public String terminarConsulta(@RequestParam(name = "observacoes") String observacoes) throws Exception {
        Consulta consultaDB = consultasService.getConsultaById(idEmergencia);
        consultaDB.setEstado("Realizada");
        consultaDB.setObservacoes(observacoes);

        CreateInvoiceRequest request = new CreateInvoiceRequest();
        request.setIdConsulta(consultaDB.getIdConsulta());
        request.setName(consultaDB.getIdUtente().getNome());
        request.setNif(consultaDB.getIdUtente().getNif());
        request.setEmail(consultaDB.getIdUtente().getEmail());
        request.setValue("60");

        String url = faturacaoService.createInvoice(request, consultaDB);
        consultaDB.setUrl(url);
        consultasService.updateConsulta(consultaDB);

        return "redirect:/med_lista_espera";
    }

    // --------------------------------

    @GetMapping(value = "/med_consulta")
    public String showRegistoMedico291(ModelMap map) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        map.put("consultas", consultasService.getConsultasByMedico(username));
        return "med_consulta";
    }

    // --------------------------------


    @GetMapping(value = "/med_contactos")
    public String showRegistoMedico292() {
        return "med_contactos";
    }


    // --------------------------------

    @GetMapping(value = "/med_info_gerais")
    public String showRegistoMedico295() {
        return "med_info_gerais";
    }

    // --------------------------------


    @GetMapping(value = "/med_medicos")
    public String showRegistoMedico296(ModelMap map) {
        map.put("medicos", medicosService.getAllMedicos());
        return "med_medicos";
    }

    // --------------------------------


    @GetMapping(value = "/med_perfil")
    public String showRegistoMedico297(ModelMap map) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        map.put("medico", medicosService.getAllMedicos());//mapear a base de dados para o site
        return "med_perfil";
    }

    // --------------------------------

    @GetMapping(value = "/med_editar_perfil")
    public String showRegistoMedico293(ModelMap map) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        map.put("medico", medicosService.getMedicoByNome(username));//mapear a base de dados para o site
        return "med_editar_perfil";
    }

    @PostMapping(value = "/med_editar_perfil")
    public String updateAdmin(Medico medico, ModelMap map) {
        Medico medicoDB = medicosService.getMedicoById(medico.getIdMedico());
        medicoDB.setContacto(medico.getContacto());
        medicoDB.setAndar(medico.getAndar());
        medicoDB.setCodigoPostal(medico.getCodigoPostal());
        medicoDB.setLocalidade(medico.getLocalidade());
        medicoDB.setEndereco(medico.getEndereco());
        medicoDB.setCv(medico.getCv());
        map.put("medico", medicoDB);
        medicosService.updateMedico(medicoDB);
        return "redirect:/med_perfil";
    }

    // --------------------------------

    @GetMapping(value = "/med_home")
    public String showRegistoMedico298(ModelMap map) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        map.put("username", username);
        map.put("atrasados", consultasService.atrasoConsultaMedico(LocalTime.now(), username));
        map.put("aguardar", listaEsperaService.countAllListaEsperaByMedico(username));

        try {
            map.put("proximo", listaEsperaService.getNext(username));
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }


        return "med_home";
    }

    @PostMapping(value = "/med_home")
    public String iniciarConsultaHome(@RequestParam(name = "idSenha") Long id) {
        ListaEspera le = listaEsperaService.getListaEsperaById(id);
        Consulta consulta = listaEsperaService.getListaEsperaById(id).getConsulta();
        consulta.setEstado("Iniciada");
        consulta.setListaEspera(null);
        consultasService.updateConsulta(consulta);
        idEmergencia = consulta.getIdConsulta();
        listaEsperaService.deleteListaEspera(le);
        return "redirect:/med_consulta_iniciada";
    }

    // --------------------------------

    @GetMapping(value = "/med_utentes")
    public String showRegistoMedico287(ModelMap map) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        map.put("utentes", consultasService.getConsultasByMedico(username));
        return "med_utentes";
    }

    @GetMapping(value = "/med_perfil_utente/{id}")
    public  String showPerfilUtente(@PathVariable Long id, ModelMap map) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        map.put("utente", utenteService.getUtenteById(id));
        map.put("consultasList", consultasService.getConsultaByMedicoAndIdUtente(username, id));

        return "med_perfil_utente";
    }

    // --------------------------------

    @GetMapping(value = "/med_lista_espera")
    public String showMedicoListaEspera(ModelMap map) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        map.put("listaEspera", listaEsperaService.getAllListaEsperaByNomeMedico(username));
        map.put("aguardar", listaEsperaService.countAllListaEsperaByMedico(username));
        map.put("atrasados", consultasService.atrasoConsultaMedico(LocalTime.now(), username));
        try {
            map.put("proximo", listaEsperaService.getNext(username));
        } catch (Exception e){
            System.out.println("Something went wrong.");
        }


        return "med_lista_espera";
    }

    @PostMapping(value = "/med_lista_espera")
    public String iniciarConsulta(@RequestParam(name = "idSenha") Long id) {
        ListaEspera le = listaEsperaService.getListaEsperaById(id);
        Consulta consulta = listaEsperaService.getListaEsperaById(id).getConsulta();
        consulta.setEstado("Iniciada");
        consulta.setListaEspera(null);
        consultasService.updateConsulta(consulta);
        idEmergencia = consulta.getIdConsulta();
        listaEsperaService.deleteListaEspera(le);
        return "redirect:/med_consulta_iniciada";
    }
    // --------------------------------

    @GetMapping(value = "/med_consulta_details/{id}")
    public String medConsultaDetails(@PathVariable Long id, ModelMap map){
        map.put("consulta", consultasService.getConsultaById(id));

        return "med_consulta_details";
    }
}
