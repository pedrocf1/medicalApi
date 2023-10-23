package medi.voll.api.paciente;

import jakarta.validation.Valid;
import medi.voll.api.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        Long id,
        String nome,
        String telefone,
        @Valid DadosEndereco endereco
) {
}
