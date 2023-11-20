package medi.voll.api.domain.consulta.validacoes;

import medi.voll.api.domain.ValidacaoException;
import medi.voll.api.domain.consulta.DadosAgendamentoConsulta;
import medi.voll.api.domain.paciente.PacienteRepository;

public class ValidadorPacienteAtivo {

    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        if (dados.idMedico() == null) {
            return;
        }

        var pacienteEstaAtivo = repository.findAtivoById(dados.idMedico());
        if(!pacienteEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com médico excluido");
        }
    }
}
