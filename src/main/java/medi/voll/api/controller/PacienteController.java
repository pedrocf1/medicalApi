package medi.voll.api.controller;


import jakarta.validation.Valid;
import medi.voll.api.paciente.DadosCadastroPaciente;
import medi.voll.api.paciente.DadosListagemPaciente;
import medi.voll.api.paciente.Paciente;
import medi.voll.api.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
            repository.save(new Paciente(dados));
    }



    @GetMapping
    public Page<DadosListagemPaciente> listar(Pageable page){
        return repository.findAll(page).map(DadosListagemPaciente::new);
    }

}
