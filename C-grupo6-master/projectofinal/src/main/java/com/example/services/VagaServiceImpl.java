package com.example.services;

import com.example.entity.Disponibilidade;
import com.example.entity.Vaga;
import com.example.repositories.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.List;

@Service
public class VagaServiceImpl implements VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private DisponibilidadeServiceImpl disponibilidadeService;

    @Autowired
    private ConsultasService consultasService;

    @Override
    public List<Vaga> getAllVagas() {
        return vagaRepository.findAll();
    }

    @Override
    public List<Vaga> getAllVagasByDisponivel() {
        return vagaRepository.findAllByDisponivelTrue();
    }

    @Override
    public List<Vaga> getAllVagasByUsername(String username) {
        return vagaRepository.findVagasByDisponibilidade_Medico_nome(username);
    }

    @Override
    public Vaga getVagaById(Long id) {
        return vagaRepository.findById(id).orElse(null);
    }

    @Override
    public void createVaga(Vaga vaga) {
        vagaRepository.save(vaga);
    }

    @Override
    public void updateVaga(Long id, Vaga vaga) {
        vagaRepository.save(vaga);
    }

    @Scheduled(cron = "0 0 0 1 1/1 ? *")
    public void generateNextMonthAvailability() {
        LocalDate currentDate = LocalDate.now();
        LocalDate firstOfNextMonth = currentDate.plusMonths(1).withDayOfMonth(1);

        for (Disponibilidade disponibilidade : disponibilidadeService.getAllDisponibilidade()) {
            generateVagas(disponibilidade, firstOfNextMonth);
        }
    }

    public void generateVagas(Disponibilidade disponibilidade, LocalDate dataInicial) {

        for (LocalDate data = dataInicial; data.isBefore(data.with(TemporalAdjusters.lastDayOfMonth())); data = data.plusDays(1)) {
            if (data.getDayOfWeek() == DayOfWeek.MONDAY && data.getDayOfWeek() == disponibilidade.getDiaSemana()) {
                for (LocalTime hora = disponibilidade.getInicioTurno(); hora.isBefore(disponibilidade.getFimTurno()); hora = hora.plusMinutes(30)) {
                    if (hora.compareTo(disponibilidade.getInicioIntervalo()) < 0 || (hora.compareTo(disponibilidade.getFimIntervalo())) > 0) {
                        Vaga vaga = new Vaga(data, hora);
                        vaga.setDisponibilidade(disponibilidade);
                        vagaRepository.save(vaga);

                    }
                }
            } else if (data.getDayOfWeek() == DayOfWeek.TUESDAY && data.getDayOfWeek() == disponibilidade.getDiaSemana()) {
                for (LocalTime hora = disponibilidade.getInicioTurno(); hora.isBefore(disponibilidade.getFimTurno()); hora = hora.plusMinutes(30)) {
                    if (hora.compareTo(disponibilidade.getInicioIntervalo()) < 0 || (hora.compareTo(disponibilidade.getFimIntervalo())) > 0) {
                        Vaga vaga = new Vaga(data, hora);
                        vaga.setDisponibilidade(disponibilidade);
                        vagaRepository.save(vaga);

                    }
                }
            } else if (data.getDayOfWeek() == DayOfWeek.WEDNESDAY && data.getDayOfWeek() == disponibilidade.getDiaSemana()) {
                for (LocalTime hora = disponibilidade.getInicioTurno(); hora.isBefore(disponibilidade.getFimTurno()); hora = hora.plusMinutes(30)) {
                    if (hora.compareTo(disponibilidade.getInicioIntervalo()) < 0 || (hora.compareTo(disponibilidade.getFimIntervalo())) > 0) {
                        Vaga vaga = new Vaga(data, hora);
                        vaga.setDisponibilidade(disponibilidade);
                        vagaRepository.save(vaga);

                    }
                }
            } else if (data.getDayOfWeek() == DayOfWeek.THURSDAY && data.getDayOfWeek() == disponibilidade.getDiaSemana()) {
                for (LocalTime hora = disponibilidade.getInicioTurno(); hora.isBefore(disponibilidade.getFimTurno()); hora = hora.plusMinutes(30)) {
                    if (hora.compareTo(disponibilidade.getInicioIntervalo()) < 0 || (hora.compareTo(disponibilidade.getFimIntervalo())) > 0) {
                        Vaga vaga = new Vaga(data, hora);
                        vaga.setDisponibilidade(disponibilidade);
                        vagaRepository.save(vaga);

                    }
                }
            } else if (data.getDayOfWeek() == DayOfWeek.FRIDAY && data.getDayOfWeek() == disponibilidade.getDiaSemana()) {
                for (LocalTime hora = disponibilidade.getInicioTurno(); hora.isBefore(disponibilidade.getFimTurno()); hora = hora.plusMinutes(30)) {
                    if (hora.compareTo(disponibilidade.getInicioIntervalo()) < 0 || (hora.compareTo(disponibilidade.getFimIntervalo())) > 0) {
                        Vaga vaga = new Vaga(data, hora);
                        vaga.setDisponibilidade(disponibilidade);
                        vagaRepository.save(vaga);

                    }
                }
            }
            data.plusDays(1);
        }
    }

    @Override
    public List<Vaga> getAllByDisponivelTrueAndDataAndDisponibilidade_Medico_IdMedico(LocalDate data, Long disponibilidade_medico_idMedico) {
        return vagaRepository.findByDisponivelTrueAndDataAndDisponibilidade_Medico_IdMedicoOrderByHoraInicio(data, disponibilidade_medico_idMedico);
    }

    @Override
    public List<Vaga> getAllByDisponivelTrueAndDataAndDisponibilidade_Medico_Especialidade_IdEspecialidade(LocalDate data, Long disponibilidade_medico_especialidade) {
        return vagaRepository.findByDisponivelTrueAndDataAndDisponibilidade_Medico_Especialidade_IdEspecialidadeOrderByHoraInicio(data, disponibilidade_medico_especialidade);
    }

    @Override
    public void deleteAllVagasByIdDisponibilidade(Long idDisponibilidade) {
        for (Vaga vaga: vagaRepository.getAllByDisponibilidade_Id(idDisponibilidade)) {
            consultasService.updateConsultasByIdVaga(vaga.getId());
            vagaRepository.deleteById(vaga.getId());
        }
    }

    @Override
    public void updateVaga(Vaga vaga) {
        vagaRepository.save(vaga);
    }


}
