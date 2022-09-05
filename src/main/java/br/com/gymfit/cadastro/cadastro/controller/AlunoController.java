package br.com.gymfit.cadastro.cadastro.controller;

import br.com.gymfit.cadastro.cadastro.dominio.Aluno;
import br.com.gymfit.cadastro.cadastro.repositorio.AlunoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/aluno")
public class AlunoController {
    private final RuntimeException RUNTIME_EXCEPTION = new RuntimeException("O Id passado não é valido, estudante não existe!");
    private final AlunoRepositorio alunoRepositorio;

    @PostMapping
    public Aluno novoAluno(@RequestBody Aluno aluno) {
        return this.alunoRepositorio.save(aluno);
    }

    @PutMapping("/{id}")
    public Aluno editarAluno(@PathVariable("id") Long id, @RequestBody Aluno body) {
        var alunoSalvo = alunoRepositorio.findById(id)
                .orElseThrow(() -> RUNTIME_EXCEPTION);

        alunoSalvo.setNome(body.getNome());
        alunoSalvo.setSobrenome(body.getSobrenome());
        return alunoRepositorio.save(alunoSalvo);
    }

    @GetMapping
    public List<Aluno> verTodos() {
        return alunoRepositorio.findAll();
    }

    @DeleteMapping(("/{id}"))
    public void deleteById(@PathVariable("id") Long id) {
        Optional<Aluno> alunoOptional = alunoRepositorio.findById(id);
        if (alunoOptional.isEmpty()) {
            throw RUNTIME_EXCEPTION;
        }
        alunoRepositorio.deleteById(id);
    }
}
